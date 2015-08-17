package com.baidu.cloudsdk.assets;

import android.content.Context;
import android.content.res.Resources;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public final class AssetFileUtils {
    private AssetFileUtils() {
    }

    public static InputStream getFileAsStream(Context context, String str) {
        InputStream resourceAsStream = AssetFileUtils.class.getResourceAsStream("/com/baidu/cloudsdk/assets/" + str);
        if (resourceAsStream == null) {
            try {
                return context.getApplicationContext().getAssets().open(str);
            } catch (IOException e) {
                try {
                    return context.getApplicationContext().getResources().openRawResource(context.getApplicationContext().getResources().getIdentifier(str, "raw", context.getPackageName()));
                } catch (Resources.NotFoundException e2) {
                    try {
                        return new FileInputStream(new File(str));
                    } catch (FileNotFoundException e3) {
                        return resourceAsStream;
                    }
                }
            }
        }
        return resourceAsStream;
    }

    public static String getFileContent(Context context, String str) {
        BufferedReader bufferedReader;
        InputStream fileAsStream = getFileAsStream(context, str);
        if (fileAsStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileAsStream, "utf-8"));
            } finally {
                try {
                    fileAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            try {
                fileAsStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        try {
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    sb.append(readLine);
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return sb.toString();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
    }
}
