package com.baidu.ar.h;

import android.util.Log;
/* loaded from: classes3.dex */
public final class b {
    private static int xT = 5;

    public static void T(boolean z) {
        if (z) {
            xT = 2;
        } else {
            xT = 6;
        }
    }

    public static void aQ(String str) {
        c("ARLOG", gw() + " " + str);
    }

    public static void aR(String str) {
        k("ARLOG", gw() + " " + str);
    }

    public static void aS(String str) {
        b("ARLOG", gw() + " " + str);
    }

    public static void b(String str, String str2) {
        if (xT > 6) {
            return;
        }
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        if (xT > 3) {
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
        if (xT > 2) {
            return;
        }
        Log.v(str, str2);
    }

    public static void k(String str, String str2) {
        if (xT > 4) {
            return;
        }
        Log.i(str, str2);
    }

    public static void l(String str, String str2) {
        if (xT > 5) {
            return;
        }
        Log.w(str, str2);
    }
}
