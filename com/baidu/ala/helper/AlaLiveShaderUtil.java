package com.baidu.ala.helper;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class AlaLiveShaderUtil {
    public static String getStringFromAssert(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(TbadkCoreApplication.getInst().getAssets().open(str), HTTP.UTF_8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
