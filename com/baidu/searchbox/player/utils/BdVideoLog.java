package com.baidu.searchbox.player.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.player.BDPlayerConfig;
/* loaded from: classes15.dex */
public final class BdVideoLog {
    public static final boolean DEBUG_DEBUG = true;
    public static final boolean DEBUG_ERROR = true;
    public static final boolean DEBUG_EXCEPT = true;
    public static final boolean DEBUG_INFO = false;
    public static final boolean DEBUG_VERBOSE = false;
    public static final boolean DEBUG_WARN = true;
    public static final String LOG_TAG = "videoplayer";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public enum LogLevel {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN
    }

    private BdVideoLog() {
    }

    public static void d(String str, String str2) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.DEBUG, str, str2, null);
        }
    }

    public static void d(String str) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, null);
        }
    }

    public static void d(String str, Throwable th) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, th);
        }
    }

    public static void e(String str, String str2) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.ERROR, str, str2, null);
        }
    }

    public static void e(String str) {
        doLog(LogLevel.ERROR, LOG_TAG, str, null);
    }

    public static void ex(String str) {
        if (!TextUtils.isEmpty(str)) {
            e(str);
        }
        new Exception().printStackTrace();
    }

    public static void e(String str, Throwable th) {
        doLog(LogLevel.ERROR, LOG_TAG, str, th);
    }

    public static void i(String str, String str2) {
        if (BDPlayerConfig.isDebug()) {
        }
    }

    public static void i(String str) {
        if (BDPlayerConfig.isDebug()) {
        }
    }

    public static void i(String str, Throwable th) {
        if (BDPlayerConfig.isDebug()) {
        }
    }

    public static void v(String str, String str2) {
        if (BDPlayerConfig.isDebug()) {
        }
    }

    public static void v(String str) {
        if (BDPlayerConfig.isDebug()) {
        }
    }

    public static void v(String str, Throwable th) {
        if (BDPlayerConfig.isDebug()) {
        }
    }

    public static void w(String str) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.WARN, LOG_TAG, str, null);
        }
    }

    public static void w(String str, String str2) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.WARN, str, str2, null);
        }
    }

    public static void w(String str, Throwable th) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.WARN, LOG_TAG, str, th);
        }
    }

    public static void printStackTrace(Exception exc) {
        if (BDPlayerConfig.isDebug()) {
            exc.printStackTrace();
        }
    }

    private static void doLog(LogLevel logLevel, String str, String str2, Throwable th) {
        switch (logLevel) {
            case DEBUG:
                if (th == null) {
                    Log.d(str, str2);
                    return;
                } else {
                    Log.d(str, str2, th);
                    return;
                }
            case ERROR:
                if (th == null) {
                    Log.e(str, str2);
                    return;
                } else {
                    Log.e(str, str2, th);
                    return;
                }
            case INFO:
                if (th == null) {
                    Log.i(str, str2);
                    return;
                } else {
                    Log.i(str, str2, th);
                    return;
                }
            case VERBOSE:
                if (th == null) {
                    Log.v(str, str2);
                    return;
                } else {
                    Log.v(str, str2, th);
                    return;
                }
            case WARN:
                if (th == null) {
                    Log.w(str, str2);
                    return;
                } else {
                    Log.w(str, str2, th);
                    return;
                }
            default:
                return;
        }
    }

    public static void logException(String str, Exception exc) {
        if (exc != null) {
            try {
                if (BDPlayerConfig.isDebug()) {
                    exc.printStackTrace();
                }
                d(str, "========================= Exception Happened !!================================");
                d(str, exc.getMessage());
                for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                    d(str, stackTraceElement.toString());
                }
                d(str, "========================= Exception Ended !!================================");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
