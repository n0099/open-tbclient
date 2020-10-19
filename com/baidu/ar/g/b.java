package com.baidu.ar.g;

import android.util.Log;
/* loaded from: classes14.dex */
public final class b {
    private static int xe = 5;

    public static void V(boolean z) {
        if (z) {
            xe = 2;
        } else {
            xe = 6;
        }
    }

    public static void aN(String str) {
        c("ARLOG", gw() + " " + str);
    }

    public static void aO(String str) {
        k("ARLOG", gw() + " " + str);
    }

    public static void aP(String str) {
        b("ARLOG", gw() + " " + str);
    }

    public static void b(String str, String str2) {
        if (xe > 6) {
            return;
        }
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        if (xe > 3) {
            return;
        }
        Log.d(str, str2);
    }

    public static String gw() {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[2];
        StringBuffer stringBuffer = new StringBuffer("[");
        stringBuffer.append(stackTraceElement.getFileName());
        stringBuffer.append(" | ");
        stringBuffer.append(stackTraceElement.getLineNumber());
        stringBuffer.append(" | ");
        stringBuffer.append(stackTraceElement.getMethodName());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static void j(String str, String str2) {
        if (xe > 2) {
            return;
        }
        Log.v(str, str2);
    }

    public static void k(String str, String str2) {
        if (xe > 4) {
            return;
        }
        Log.i(str, str2);
    }

    public static void l(String str, String str2) {
        if (xe > 5) {
            return;
        }
        Log.w(str, str2);
    }
}
