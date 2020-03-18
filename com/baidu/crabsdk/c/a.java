package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes8.dex */
public final class a {
    public static String Sk = "CRAB";
    public static String Sl = "CRAB-NA";

    public static int cj(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(Sk, cl(str));
        }
        return -1;
    }

    public static int ck(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(Sk, cl(str));
        }
        return -1;
    }

    private static String cl(String str) {
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
            return Log.e(Sk, cl(str), th);
        }
        return -1;
    }

    public static int v(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(Sk, cl(str));
        }
        return -1;
    }

    public static int w(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(Sk, cl(str));
        }
        return -1;
    }
}
