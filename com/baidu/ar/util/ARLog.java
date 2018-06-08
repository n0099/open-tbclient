package com.baidu.ar.util;

import android.util.Log;
/* loaded from: classes3.dex */
public final class ARLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static int a = 5;

    private ARLog() {
    }

    public static void d(String str) {
        if (a > 3) {
            return;
        }
        Log.d("ARLOG", getFileLineMethod() + " " + str);
    }

    public static void e(String str) {
        if (a > 6) {
            return;
        }
        Log.e("ARLOG", getFileLineMethod() + " " + str);
    }

    public static String getFileLineMethod() {
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

    public static void i(String str) {
        if (a > 4) {
            return;
        }
        Log.i("ARLOG", getFileLineMethod() + " " + str);
    }

    public static void setDebugEnable(boolean z) {
        if (z) {
            a = 2;
        } else {
            a = 6;
        }
    }

    public static void v(String str) {
        if (a > 2) {
            return;
        }
        Log.v("ARLOG", getFileLineMethod() + " " + str);
    }

    public static void w(String str) {
        if (a > 5) {
            return;
        }
        Log.w("ARLOG", getFileLineMethod() + " " + str);
    }
}
