import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public void map(LongWritable offset, Text value, Context context) throws IOException, InterruptedException{
        String[] words = value.toString().split(" ");
        for(String word: words){
            context.write(new Text(word.trim().replace(".", "")), new IntWritable(1));
        }
    }
}
