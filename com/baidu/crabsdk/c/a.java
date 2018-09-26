package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes2.dex */
public final class a {
    public static String VE = "CRAB";
    public static String VF = "CRAB-NA";

    private static String cA(String str) {
        String str2;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals("com.baidu.crabsdk.util.BLog")) {
                    str2 = "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
                    break;
                }
            }
        }
        str2 = null;
        return str2 == null ? str : str2 + " - " + str;
    }

    public static int cv(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(VE, cA(str));
        }
        return -1;
    }

    public static int cw(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(VF, cA(str));
        }
        return -1;
    }

    public static int cx(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(VE, cA(str));
        }
        return -1;
    }

    public static int cy(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(VE, cA(str));
        }
        return -1;
    }

    public static int cz(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(VE, cA(str));
        }
        return -1;
    }

    public static int f(String str, Throwable th) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(VE, cA(str), th);
        }
        return -1;
    }
}
