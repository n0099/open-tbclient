package com.baidu.searchbox.player.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.player.BDPlayerConfig;
/* loaded from: classes2.dex */
public final class BdVideoLog {
    public static final boolean DEBUG_DEBUG = true;
    public static final boolean DEBUG_ERROR = true;
    public static final boolean DEBUG_EXCEPT = true;
    public static final boolean DEBUG_INFO = false;
    public static final boolean DEBUG_VERBOSE = false;
    public static final boolean DEBUG_WARN = true;
    public static final String LOG_TAG = "videoplayer";

    /* renamed from: com.baidu.searchbox.player.utils.BdVideoLog$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[LogLevel.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[LogLevel.WARN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum LogLevel {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN
    }

    public static void d(String str, String str2) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.DEBUG, str, str2, null);
        }
    }

    public static void doLog(LogLevel logLevel, String str, String str2, Throwable th) {
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$searchbox$player$utils$BdVideoLog$LogLevel[logLevel.ordinal()];
        if (i2 == 1) {
            if (th == null) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, th);
            }
        } else if (i2 == 2) {
            if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        } else if (i2 == 3) {
            if (th == null) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, th);
            }
        } else if (i2 == 4) {
            if (th == null) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, th);
            }
        } else if (i2 != 5) {
        } else {
            if (th == null) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, th);
            }
        }
    }

    public static void e(String str, String str2) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.ERROR, str, str2, null);
        }
    }

    public static void ex(String str) {
        if (!TextUtils.isEmpty(str)) {
            e(str);
        }
        new Exception().printStackTrace();
    }

    public static void i(String str, String str2) {
        BDPlayerConfig.isDebug();
    }

    public static void logException(String str, Exception exc) {
        if (exc == null) {
            return;
        }
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void printStackTrace(Exception exc) {
        if (BDPlayerConfig.isDebug()) {
            exc.printStackTrace();
        }
    }

    public static void v(String str, String str2) {
        BDPlayerConfig.isDebug();
    }

    public static void w(String str) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.WARN, LOG_TAG, str, null);
        }
    }

    public static void i(String str) {
        BDPlayerConfig.isDebug();
    }

    public static void v(String str) {
        BDPlayerConfig.isDebug();
    }

    public static void d(String str) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, null);
        }
    }

    public static void e(String str) {
        doLog(LogLevel.ERROR, LOG_TAG, str, null);
    }

    public static void i(String str, Throwable th) {
        BDPlayerConfig.isDebug();
    }

    public static void v(String str, Throwable th) {
        BDPlayerConfig.isDebug();
    }

    public static void w(String str, String str2) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.WARN, str, str2, null);
        }
    }

    public static void e(String str, Throwable th) {
        doLog(LogLevel.ERROR, LOG_TAG, str, th);
    }

    public static void d(String str, Throwable th) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, th);
        }
    }

    public static void w(String str, Throwable th) {
        if (BDPlayerConfig.isDebug()) {
            doLog(LogLevel.WARN, LOG_TAG, str, th);
        }
    }
}
