package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes6.dex */
public final class a {
    public static String QC = "CRAB";
    public static String QD = "CRAB-NA";

    public static int cb(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(QC, ce(str));
        }
        return -1;
    }

    public static int cc(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(QD, ce(str));
        }
        return -1;
    }

    public static int cd(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(QC, ce(str));
        }
        return -1;
    }

    private static String ce(String str) {
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
            return Log.e(QC, ce(str), th);
        }
        return -1;
    }

    public static int v(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(QC, ce(str));
        }
        return -1;
    }

    public static int w(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(QC, ce(str));
        }
        return -1;
    }
}
