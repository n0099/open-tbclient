package com.baidu.ar.util;

import android.util.Log;
/* loaded from: classes3.dex */
public final class b {
    private static int a = 5;

    public static String a() {
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

    public static void a(String str) {
        if (a > 3) {
            return;
        }
        Log.e("ARLOG", a() + " " + str);
    }

    public static void a(boolean z) {
        if (z) {
            a = 2;
        } else {
            a = 6;
        }
    }

    public static void b(String str) {
        if (a > 4) {
            return;
        }
        Log.i("ARLOG", a() + " " + str);
    }

    public static void c(String str) {
        if (a > 5) {
            return;
        }
        Log.w("ARLOG", a() + " " + str);
    }

    public static void d(String str) {
        if (a > 6) {
            return;
        }
        Log.e("ARLOG", a() + " " + str);
    }
}
