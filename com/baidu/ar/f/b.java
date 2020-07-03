package com.baidu.ar.f;

import android.util.Log;
/* loaded from: classes3.dex */
public final class b {
    private static int wG = 5;

    public static void V(boolean z) {
        if (z) {
            wG = 2;
        } else {
            wG = 6;
        }
    }

    public static void aJ(String str) {
        c("ARLOG", fi() + " " + str);
    }

    public static void aK(String str) {
        i("ARLOG", fi() + " " + str);
    }

    public static void aL(String str) {
        b("ARLOG", fi() + " " + str);
    }

    public static void b(String str, String str2) {
        if (wG > 6) {
            return;
        }
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        if (wG > 3) {
            return;
        }
        Log.d(str, str2);
    }

    public static String fi() {
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

    public static void h(String str, String str2) {
        if (wG > 2) {
            return;
        }
        Log.v(str, str2);
    }

    public static void i(String str, String str2) {
        if (wG > 4) {
            return;
        }
        Log.i(str, str2);
    }

    public static void j(String str, String str2) {
        if (wG > 5) {
            return;
        }
        Log.w(str, str2);
    }
}
