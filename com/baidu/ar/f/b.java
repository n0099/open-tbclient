package com.baidu.ar.f;

import android.util.Log;
/* loaded from: classes3.dex */
public final class b {
    private static int wg = 5;

    public static void U(boolean z) {
        if (z) {
            wg = 2;
        } else {
            wg = 6;
        }
    }

    public static void aI(String str) {
        c("ARLOG", eS() + " " + str);
    }

    public static void aJ(String str) {
        i("ARLOG", eS() + " " + str);
    }

    public static void aK(String str) {
        b("ARLOG", eS() + " " + str);
    }

    public static void b(String str, String str2) {
        if (wg > 6) {
            return;
        }
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        if (wg > 3) {
            return;
        }
        Log.d(str, str2);
    }

    public static String eS() {
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
        if (wg > 2) {
            return;
        }
        Log.v(str, str2);
    }

    public static void i(String str, String str2) {
        if (wg > 4) {
            return;
        }
        Log.i(str, str2);
    }

    public static void j(String str, String str2) {
        if (wg > 5) {
            return;
        }
        Log.w(str, str2);
    }
}
