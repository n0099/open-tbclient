package com.baidu.browser.core.util;

import android.os.Environment;
import android.util.Log;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes11.dex */
public final class BdLog {
    private static FileOutputStream IR;
    private static boolean sDebug = true;
    private static boolean IS = false;
    private static String IT = Environment.getExternalStorageDirectory() + File.separator + "baidu" + File.separator + "flyflow" + File.separator + TbConfig.TMP_LOG_DIR_NAME + File.separator;
    private static String IU = IT + "baiduliulanqi_log.txt";
    private static String IW = IT + "baiduliulanqi_lasttime_log.txt";
    private static boolean IX = false;

    /* loaded from: classes11.dex */
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
        if (IS) {
            L(str, str2);
        }
    }

    private static void L(String str, String str2) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                File file = new File(IT);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (IR == null) {
                    IR = new FileOutputStream(IU);
                }
                IR.write((str + " : " + str2).getBytes("UTF-8"));
                IR.write("\n".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
