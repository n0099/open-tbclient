package com.baidu.browser.core.util;

import android.os.Environment;
import android.util.Log;
import com.baidu.android.imsdk.BuildConfig;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes9.dex */
public final class BdLog {
    private static FileOutputStream In;
    private static boolean sDebug = true;
    private static boolean Io = false;
    private static String Ip = Environment.getExternalStorageDirectory() + File.separator + BuildConfig.FLAVOR + File.separator + "flyflow" + File.separator + TbConfig.TMP_LOG_DIR_NAME + File.separator;
    private static String Iq = Ip + "baiduliulanqi_log.txt";
    private static String Ir = Ip + "baiduliulanqi_lasttime_log.txt";
    private static boolean Is = false;

    /* loaded from: classes9.dex */
    private enum LogLevel {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void d(String str, String str2) {
        if (sDebug) {
        }
    }

    public static void d(String str) {
        if (sDebug) {
        }
    }

    public static void e(String str, Throwable th) {
        a(LogLevel.ERROR, "FlyFlow", str, th);
    }

    private static void a(LogLevel logLevel, String str, String str2, Throwable th) {
        if (str2 == null) {
            str2 = "";
        }
        switch (logLevel) {
            case DEBUG:
                if (th == null) {
                    Log.d(str, str2);
                    break;
                } else {
                    Log.d(str, str2, th);
                    break;
                }
            case ERROR:
                if (th == null) {
                    Log.e(str, str2);
                    break;
                } else {
                    Log.e(str, str2, th);
                    break;
                }
            case INFO:
                if (th == null) {
                    Log.i(str, str2);
                    break;
                } else {
                    Log.i(str, str2, th);
                    break;
                }
            case VERBOSE:
                if (th == null) {
                    Log.v(str, str2);
                    break;
                } else {
                    Log.v(str, str2, th);
                    break;
                }
            case WARN:
                if (th == null) {
                    Log.w(str, str2);
                    break;
                } else {
                    Log.w(str, str2, th);
                    break;
                }
        }
        if (Io) {
            J(str, str2);
        }
    }

    private static void J(String str, String str2) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                File file = new File(Ip);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (In == null) {
                    In = new FileOutputStream(Iq);
                }
                In.write((str + " : " + str2).getBytes("UTF-8"));
                In.write("\n".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
