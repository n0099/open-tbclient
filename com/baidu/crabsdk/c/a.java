package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes3.dex */
public final class a {
    public static String aar = "CRAB";
    public static String aas = "CRAB-NA";

    public static int a(String str, Throwable th) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(aar, ck(str), th);
        }
        return -1;
    }

    public static int ch(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(aar, ck(str));
        }
        return -1;
    }

    public static int ci(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(aas, ck(str));
        }
        return -1;
    }

    public static int cj(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(aar, ck(str));
        }
        return -1;
    }

    private static String ck(String str) {
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

    public static int v(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(aar, ck(str));
        }
        return -1;
    }

    public static int w(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(aar, ck(str));
        }
        return -1;
    }
}
