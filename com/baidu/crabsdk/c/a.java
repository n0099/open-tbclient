package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes11.dex */
public final class a {
    public static String aoR = "CRAB";
    public static String aoS = "CRAB-NA";

    public static int a(String str, Throwable th) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(aoR, dC(str), th);
        }
        return -1;
    }

    public static int dA(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(aoR, dC(str));
        }
        return -1;
    }

    public static int dB(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(aoR, dC(str));
        }
        return -1;
    }

    private static String dC(String str) {
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
            return Log.d(aoR, dC(str));
        }
        return -1;
    }

    public static int w(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(aoR, dC(str));
        }
        return -1;
    }
}
