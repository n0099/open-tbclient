package com.baidu.lcp.sdk.d;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes14.dex */
public class c {
    private static c aAp;
    private static File aAq;
    private static Context mContext;

    public static c aL(Context context) {
        Log.i("LogToFileUtils", "init ...");
        if (mContext == null || aAp == null || aAq == null || !aAq.exists()) {
            mContext = context;
            aAp = new c();
            aAq = getLogFile();
            write("imsdkversion:" + BK());
            write("lcpsdkversion:" + BJ());
            Log.i("LogToFileUtils", "LogFilePath is: " + aAq.getPath());
        } else {
            Log.i("LogToFileUtils", "LogToFileUtils has been init ...");
        }
        return aAp;
    }

    public static void write(Object obj) {
        if (mContext == null || aAp == null || aAq == null || !aAq.exists()) {
            Log.e("LogToFileUtils", "Initialization failure !!!");
            return;
        }
        String str = System.currentTimeMillis() + ":" + obj.toString();
        Log.i("LogToFileUtils", str);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(aAq, true));
            bufferedWriter.write(str);
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
        } catch (Exception e) {
            Log.e("LogToFileUtils", "Write failure !!! " + e.toString());
        }
    }

    private static String BJ() {
        return "2240016";
    }

    private static String BK() {
        String str = "";
        try {
            Class<?> cls = Class.forName("com.baidu.android.imsdk.internal.IMConfigInternal");
            str = String.valueOf(cls.getMethod("getSDKVersionValue", Context.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), mContext));
            return String.format("%s.%s.%s", str.substring(0, 1), str.substring(1, 2), str.substring(2, 3));
        } catch (Exception e) {
            String str2 = str;
            Log.i("LogToFileUtils", e.getMessage());
            e.printStackTrace();
            return str2;
        }
    }

    private static File getLogFile() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(mContext.getExternalFilesDir("Log").getPath() + "/");
            Log.i("LogToFileUtils", "file path ..." + file.getPath());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file.getPath() + "/logs.txt");
            if (file2.exists()) {
                file2.delete();
            }
            try {
                file2.createNewFile();
                return file2;
            } catch (Exception e) {
                Log.e("LogToFileUtils", "Create log file failure !!! " + e.toString());
                return file2;
            }
        }
        Log.e("LogToFileUtils", "sd not mounted");
        return null;
    }
}
