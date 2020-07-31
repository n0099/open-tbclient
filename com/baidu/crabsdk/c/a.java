package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes12.dex */
public final class a {
    public static String amC = "CRAB";
    public static String amD = "CRAB-NA";

    public static int a(String str, Throwable th) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(amC, dj(str), th);
        }
        return -1;
    }

    public static int dh(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(amC, dj(str));
        }
        return -1;
    }

    public static int di(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(amC, dj(str));
        }
        return -1;
    }

    private static String dj(String str) {
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
            return Log.d(amC, dj(str));
        }
        return -1;
    }

    public static int w(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(amC, dj(str));
        }
        return -1;
    }
}
