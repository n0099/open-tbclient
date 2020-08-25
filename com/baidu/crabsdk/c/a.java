package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes6.dex */
public final class a {
    public static String anE = "CRAB";
    public static String anF = "CRAB-NA";

    public static int a(String str, Throwable th) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(anE, du(str), th);
        }
        return -1;
    }

    public static int ds(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(anE, du(str));
        }
        return -1;
    }

    public static int dt(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(anE, du(str));
        }
        return -1;
    }

    private static String du(String str) {
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
            return Log.d(anE, du(str));
        }
        return -1;
    }

    public static int w(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(anE, du(str));
        }
        return -1;
    }
}
