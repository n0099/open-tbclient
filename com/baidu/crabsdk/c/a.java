package com.baidu.crabsdk.c;

import android.util.Log;
import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public final class a {
    public static String acg = "CRAB";
    public static String ach = "CRAB-NA";

    public static int cv(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(acg, cy(str));
        }
        return -1;
    }

    public static int cw(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(ach, cy(str));
        }
        return -1;
    }

    public static int cx(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(acg, cy(str));
        }
        return -1;
    }

    private static String cy(String str) {
        String str2;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals("com.baidu.crabsdk.util.BLog")) {
                    str2 = "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + Config.TRACE_TODAY_VISIT_SPLIT + stackTraceElement.getLineNumber() + "]";
                    break;
                }
            }
        }
        str2 = null;
        return str2 == null ? str : str2 + " - " + str;
    }

    public static int f(String str, Throwable th) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(acg, cy(str), th);
        }
        return -1;
    }

    public static int v(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(acg, cy(str));
        }
        return -1;
    }

    public static int w(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(acg, cy(str));
        }
        return -1;
    }
}
