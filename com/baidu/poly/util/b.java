package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes2.dex */
public class b {
    private static String aBq;
    private static String aBr;
    private static int aBs;
    private static boolean aBt = true;

    public static void enable(boolean z) {
        aBt = z;
    }

    private static String dI(String str) {
        return Thread.currentThread().getName() + "[" + aBq + ":" + aBr + ":" + aBs + "]" + str;
    }

    private static void b(StackTraceElement[] stackTraceElementArr) {
        aBq = stackTraceElementArr[1].getFileName();
        aBr = stackTraceElementArr[1].getMethodName();
        aBs = stackTraceElementArr[1].getLineNumber();
    }

    private static String h(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return dI(sb.toString());
    }

    public static void g(String str, Throwable th) {
        if (aBt) {
            b(new Throwable().getStackTrace());
            Log.e("PaySdk", h(str), th);
        }
    }

    public static void j(Object... objArr) {
        if (aBt) {
            b(new Throwable().getStackTrace());
            Log.d("PaySdk", h(objArr));
        }
    }
}
