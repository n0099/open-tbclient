package com.baidu.browser.core.util;

import android.util.Log;
/* loaded from: classes.dex */
public class BdLog {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$core$util$BdLog$LogLevel = null;
    public static final boolean DEBUG_DEBUG = true;
    public static final boolean DEBUG_ERROR = true;
    public static final boolean DEBUG_EXCEPT = true;
    public static final boolean DEBUG_INFO = true;
    public static final boolean DEBUG_LOG = true;
    public static final boolean DEBUG_VERBOSE = true;
    public static final boolean DEBUG_WARN = true;
    private static final String FILE_TYPE = ".java";
    public static final boolean LAUNCH_TIME_DEBUG = false;
    private static final String[] MODEL_FILTER = {"BdLog"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum LogLevel {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static LogLevel[] valuesCustom() {
            LogLevel[] valuesCustom = values();
            int length = valuesCustom.length;
            LogLevel[] logLevelArr = new LogLevel[length];
            System.arraycopy(valuesCustom, 0, logLevelArr, 0, length);
            return logLevelArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$core$util$BdLog$LogLevel() {
        int[] iArr = $SWITCH_TABLE$com$baidu$browser$core$util$BdLog$LogLevel;
        if (iArr == null) {
            iArr = new int[LogLevel.valuesCustom().length];
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LogLevel.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[LogLevel.WARN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $SWITCH_TABLE$com$baidu$browser$core$util$BdLog$LogLevel = iArr;
        }
        return iArr;
    }

    public static void d(String str) {
        myLog(LogLevel.DEBUG, str, 2, true, null);
    }

    public static void d(String str, Throwable th) {
        myLog(LogLevel.DEBUG, str, 2, true, th);
    }

    public static void e(String str) {
        myLog(LogLevel.ERROR, str, 2, true, null);
    }

    public static void e(String str, Throwable th) {
        myLog(LogLevel.ERROR, str, 2, true, th);
    }

    public static void i(String str) {
        myLog(LogLevel.INFO, str, 2, true, null);
    }

    public static void i(String str, Throwable th) {
        myLog(LogLevel.INFO, str, 2, true, th);
    }

    public static void v(String str) {
        myLog(LogLevel.VERBOSE, str, 2, true, null);
    }

    public static void v(String str, Throwable th) {
        myLog(LogLevel.VERBOSE, str, 2, true, th);
    }

    public static void w(String str) {
        myLog(LogLevel.WARN, str, 2, true, null);
    }

    public static void w(String str, Throwable th) {
        myLog(LogLevel.WARN, str, 2, true, th);
    }

    public static void printStackTrace(Exception exc) {
        exc.printStackTrace();
    }

    private static void myLog(LogLevel logLevel, String str, int i, boolean z, Throwable th) {
        String format;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i];
        String fileName = stackTraceElement.getFileName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        String replace = (fileName == null || !fileName.contains(FILE_TYPE)) ? fileName : fileName.replace(FILE_TYPE, "");
        if (replace != null) {
            for (String str2 : MODEL_FILTER) {
                if (replace.equals(str2)) {
                    return;
                }
            }
        }
        if (z) {
            format = String.format("[%s: %s: %d]%s", replace, methodName, Integer.valueOf(lineNumber), str);
        } else {
            format = String.format("[%s: %d]%s", replace, Integer.valueOf(lineNumber), str);
        }
        switch ($SWITCH_TABLE$com$baidu$browser$core$util$BdLog$LogLevel()[logLevel.ordinal()]) {
            case 1:
                if (th == null) {
                    Log.d("FlyFlow", format);
                    return;
                } else {
                    Log.d("FlyFlow", format, th);
                    return;
                }
            case 2:
                if (th == null) {
                    Log.e("FlyFlow", format);
                    return;
                } else {
                    Log.e("FlyFlow", format, th);
                    return;
                }
            case 3:
                if (th == null) {
                    Log.i("FlyFlow", format);
                    return;
                } else {
                    Log.i("FlyFlow", format, th);
                    return;
                }
            case 4:
                if (th == null) {
                    Log.v("FlyFlow", format);
                    return;
                } else {
                    Log.v("FlyFlow", format, th);
                    return;
                }
            case 5:
                if (th == null) {
                    Log.w("FlyFlow", format);
                    return;
                } else {
                    Log.w("FlyFlow", format, th);
                    return;
                }
            default:
                return;
        }
    }
}
