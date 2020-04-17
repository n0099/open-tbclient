package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes8.dex */
public final class a {
    public static String akB = "CRAB";
    public static String akC = "CRAB-NA";

    public static int de(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(akB, dg(str));
        }
        return -1;
    }

    public static int df(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(akB, dg(str));
        }
        return -1;
    }

    private static String dg(String str) {
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
            return Log.e(akB, dg(str), th);
        }
        return -1;
    }

    public static int v(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(akB, dg(str));
        }
        return -1;
    }

    public static int w(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(akB, dg(str));
        }
        return -1;
    }
}
