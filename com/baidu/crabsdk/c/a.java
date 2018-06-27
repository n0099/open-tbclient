package com.baidu.crabsdk.c;

import android.util.Log;
import com.baidu.ar.util.SystemInfoUtil;
/* loaded from: classes2.dex */
public final class a {
    public static String Te = "CRAB";
    public static String Tf = "CRAB-NA";

    public static int b(String str, Throwable th) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(Te, ci(str), th);
        }
        return -1;
    }

    public static int cd(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.i(Te, ci(str));
        }
        return -1;
    }

    public static int ce(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(Tf, ci(str));
        }
        return -1;
    }

    public static int cf(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.d(Te, ci(str));
        }
        return -1;
    }

    public static int cg(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.e(Te, ci(str));
        }
        return -1;
    }

    public static int ch(String str) {
        if (com.baidu.crabsdk.a.F) {
            return Log.w(Te, ci(str));
        }
        return -1;
    }

    private static String ci(String str) {
        String str2;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals("com.baidu.crabsdk.util.BLog")) {
                    str2 = "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + SystemInfoUtil.COLON + stackTraceElement.getLineNumber() + "]";
                    break;
                }
            }
        }
        str2 = null;
        return str2 == null ? str : str2 + " - " + str;
    }
}
