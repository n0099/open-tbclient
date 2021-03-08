package com.baidu.lcp.sdk.d;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes3.dex */
public class c {
    private static c axh;
    private static File axi;
    private static Context mContext;

    public static c aI(Context context) {
        Log.i("LogToFileUtils", "init ...");
        if (mContext == null || axh == null || axi == null || !axi.exists()) {
            mContext = context;
            axh = new c();
            axi = getLogFile();
            write("imsdkversion:" + xd());
            write("lcpsdkversion:" + xc());
            Log.i("LogToFileUtils", "LogFilePath is: " + axi.getPath());
        } else {
            Log.i("LogToFileUtils", "LogToFileUtils has been init ...");
        }
        return axh;
    }

    public static void write(Object obj) {
        if (mContext == null || axh == null || axi == null || !axi.exists()) {
            Log.e("LogToFileUtils", "Initialization failure !!!");
            return;
        }
        String str = System.currentTimeMillis() + ":" + obj.toString();
        Log.i("LogToFileUtils", str);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(axi, true));
            bufferedWriter.write(str);
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
        } catch (Exception e) {
            Log.e("LogToFileUtils", "Write failure !!! " + e.toString());
        }
    }

    private static String xc() {
        return "2240016";
    }

    private static String xd() {
        try {
            Class<?> cls = Class.forName("com.baidu.android.imsdk.internal.IMConfigInternal");
            String valueOf = String.valueOf(cls.getMethod("getSDKVersionValue", Context.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), mContext));
            return String.format("%s.%s.%s", valueOf.substring(0, 1), valueOf.substring(1, 2), valueOf.substring(2, 3));
        } catch (Exception e) {
            Log.i("LogToFileUtils", e.getMessage());
            e.printStackTrace();
            return "";
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
