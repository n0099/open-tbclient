package com.baidu.crabsdk.c;

import android.util.Log;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f4709a = "CRAB";

    public static int a(String str, Throwable th) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(f4709a, f(str), th);
        }
        return -1;
    }

    public static int b(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(f4709a, f(str));
        }
        return -1;
    }

    public static int c(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(f4709a, f(str));
        }
        return -1;
    }

    public static int d(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(f4709a, f(str));
        }
        return -1;
    }

    public static int e(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(f4709a, f(str));
        }
        return -1;
    }

    public static String f(String str) {
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
        if (str2 == null) {
            return str;
        }
        return str2 + " - " + str;
    }
}
