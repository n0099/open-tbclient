package com.baidu.browser.core.util;

import android.os.Environment;
import android.util.Log;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes2.dex */
public final class BdLog {
    private static FileOutputStream Vr;
    private static boolean sDebug = true;
    private static boolean Vs = false;
    private static String mFolderName = Environment.getExternalStorageDirectory() + File.separator + "baidu" + File.separator + "flyflow" + File.separator + TbConfig.TMP_LOG_DIR_NAME + File.separator;
    private static String Vt = mFolderName + "baiduliulanqi_log.txt";
    private static String Vu = mFolderName + "baiduliulanqi_lasttime_log.txt";
    private static boolean Vv = false;

    /* loaded from: classes2.dex */
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

    public static void d(String str) {
        if (sDebug) {
            a(LogLevel.DEBUG, "FlyFlow", str, null);
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
        if (Vs) {
            U(str, str2);
        }
    }

    private static void U(String str, String str2) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                File file = new File(mFolderName);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (Vr == null) {
                    Vr = new FileOutputStream(Vt);
                }
                Vr.write((str + " : " + str2).getBytes("UTF-8"));
                Vr.write("\n".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
