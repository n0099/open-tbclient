package com.baidu.adp.lib.util;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class BdLog {
    public static final String LOG_TAG = "BaiduLog";
    public static String LogFilter_classNameStartsWith;
    public static ArrayList<String> logPackage = new ArrayList<>();

    public static void addLogPackage(String str) {
        if (TextUtils.isEmpty(str) || logPackage.contains(str)) {
            return;
        }
        logPackage.add(str);
    }

    public static String createMsg(boolean z, String str, String str2, String str3) {
        if (isDebugMode()) {
            String str4 = LogFilter_classNameStartsWith;
            if (str4 == null || str3.startsWith(str4)) {
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

    public static void d(String str, String str2, String str3) {
        String createMsg = createMsg(true, str, str2, str3);
        if (createMsg != null) {
            Log.d(LOG_TAG, createMsg);
        }
    }

    public static int detailException(String str, Throwable th) {
        if (isDebugMode() && th != null) {
            Log.e(LOG_TAG, str, th);
        }
        return printLog(0, str);
    }

    public static void e(String str, String str2, String str3) {
        String createMsg = createMsg(false, str, str2, str3);
        if (createMsg != null) {
            Log.e(LOG_TAG, createMsg);
        }
    }

    public static void i(String str, String str2, String str3) {
        String createMsg = createMsg(true, str, str2, str3);
        if (createMsg != null) {
            Log.i(LOG_TAG, createMsg);
        }
    }

    public static boolean isDebugMode() {
        if (BdBaseApplication.getInst() == null) {
            return false;
        }
        return BdBaseApplication.getInst().isDebugMode();
    }

    public static boolean isLogable(String str) {
        boolean z = false;
        if (logPackage.size() == 0) {
            return false;
        }
        Iterator<String> it = logPackage.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                z = true;
            }
        }
        return z;
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
                    return 0;
                } else if (i == 1) {
                    w(className, methodName, str);
                    return 0;
                } else if (i == 2) {
                    i(className, methodName, str);
                    return 0;
                } else if (i == 3) {
                    d(className, methodName, str);
                    return 0;
                } else {
                    v(className, methodName, str);
                    return 0;
                }
            }
            return -1;
        }
        return -1;
    }

    public static void setClassNameStartWithLogFilter(String str) {
        LogFilter_classNameStartsWith = str;
    }

    public static void v(String str, String str2, String str3) {
        String createMsg = createMsg(true, str, str2, str3);
        if (createMsg != null) {
            Log.v(LOG_TAG, createMsg);
        }
    }

    public static void w(String str, String str2, String str3) {
        String createMsg = createMsg(false, str, str2, str3);
        if (createMsg != null) {
            Log.w(LOG_TAG, createMsg);
        }
    }

    public static int d(String str) {
        return printLog(3, str);
    }

    public static int e(Throwable th) {
        return printLog(0, th.getMessage());
    }

    public static int i(String str) {
        return printLog(2, str);
    }

    public static int v(String str) {
        return printLog(4, str);
    }

    public static int w(String str) {
        return printLog(1, str);
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
}
