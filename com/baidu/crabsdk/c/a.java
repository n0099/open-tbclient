package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes3.dex */
public final class a {
    public static String JU = "CRAB";
    public static String JV = "CRAB-NA";

    public static int bu(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(JU, bx(str));
        }
        return -1;
    }

    public static int bv(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(JV, bx(str));
        }
        return -1;
    }

    public static int bw(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(JU, bx(str));
        }
        return -1;
    }

    private static String bx(String str) {
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

    public static int f(String str, Throwable th) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(JU, bx(str), th);
        }
        return -1;
    }

    public static int v(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(JU, bx(str));
        }
        return -1;
    }

    public static int w(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(JU, bx(str));
        }
        return -1;
    }
}
