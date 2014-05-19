package com.baidu.adp.lib.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class BdLog {
    private static final String LOG_TAG = "BaiduLog";
    private static String LogFilter_classNameStartsWith = null;
    private static ArrayList<String> logPackage = new ArrayList<>();

    public static void addLogPackage(String str) {
        if (!TextUtils.isEmpty(str) && !logPackage.contains(str)) {
            logPackage.add(str);
        }
    }

    public static void setClassNameStartWithLogFilter(String str) {
        LogFilter_classNameStartsWith = str;
    }

    public static boolean isDebugMode() {
        if (com.baidu.adp.base.a.getInst() == null) {
            return false;
        }
        return com.baidu.adp.base.a.getInst().isDebugMode();
    }

    public static void i(String str, String str2, String str3) {
        String createMsg = createMsg(true, str, str2, str3);
        if (createMsg != null) {
            Log.i(LOG_TAG, createMsg);
        }
    }

    public static void e(String str, String str2, String str3) {
        String createMsg = createMsg(false, str, str2, str3);
        if (createMsg != null) {
            logToSDcard(createMsg);
            Log.e(LOG_TAG, createMsg);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String createMsg = createMsg(false, str, str2, th.getMessage());
        if (createMsg != null) {
            logToSDcard(createMsg);
            Log.e(LOG_TAG, createMsg);
        }
    }

    public static void w(String str, String str2, String str3) {
        String createMsg = createMsg(false, str, str2, str3);
        if (createMsg != null) {
            Log.w(LOG_TAG, createMsg);
        }
    }

    public static void v(String str, String str2, String str3) {
        String createMsg = createMsg(true, str, str2, str3);
        if (createMsg != null) {
            Log.v(LOG_TAG, createMsg);
        }
    }

    public static void d(String str, String str2, String str3) {
        String createMsg = createMsg(true, str, str2, str3);
        if (createMsg != null) {
            Log.d(LOG_TAG, createMsg);
        }
    }

    public static void d(Class<?> cls, String str, String str2) {
        d(cls.getName(), str, str2);
    }

    public static void e(Class<?> cls, String str, Throwable th) {
        e(cls.getName(), str, th.getMessage());
    }

    private static String createMsg(boolean z, String str, String str2, String str3) {
        if (isDebugMode()) {
            if (LogFilter_classNameStartsWith == null || str3.startsWith(LogFilter_classNameStartsWith)) {
                if (!z || isLogable(str)) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append(str);
                    stringBuffer.append(":");
                    stringBuffer.append(str2);
                    stringBuffer.append(":");
                    stringBuffer.append(str3);
                    return stringBuffer.toString();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static int printLog(int i, String str) {
        if (isDebugMode()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 5) {
                return -1;
            }
            StackTraceElement stackTraceElement = stackTrace[4];
            String methodName = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            if (i <= 1 || isLogable(className)) {
                if (i == 0) {
                    e(className, methodName, str);
                } else if (i == 1) {
                    w(className, methodName, str);
                } else if (i == 2) {
                    i(className, methodName, str);
                } else if (i == 3) {
                    d(className, methodName, str);
                } else {
                    v(className, methodName, str);
                }
                return 0;
            }
            return -1;
        }
        return -1;
    }

    private static boolean isLogable(String str) {
        if (logPackage.size() == 0) {
            return false;
        }
        Iterator<String> it = logPackage.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static int detailException(String str, Throwable th) {
        if (isDebugMode() && th != null) {
            Log.e(LOG_TAG, str, th);
        }
        return printLog(0, str);
    }

    public static int detailException(Throwable th) {
        if (!isDebugMode() || th == null) {
            return -1;
        }
        Log.e(LOG_TAG, th.getMessage(), th);
        return printLog(0, th.getMessage());
    }

    public static int e(String str) {
        return printLog(0, str);
    }

    public static int w(String str) {
        return printLog(1, str);
    }

    public static int i(String str) {
        return printLog(2, str);
    }

    public static int d(String str) {
        return printLog(3, str);
    }

    public static int v(String str) {
        return printLog(4, str);
    }

    private static void logToSDcard(String str) {
        new Thread(new f(str)).start();
    }
}
