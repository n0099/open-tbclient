package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes2.dex */
public class b {
    private static String aBI;
    private static String aBJ;
    private static int aBK;
    private static boolean aBL = true;

    public static void enable(boolean z) {
        aBL = z;
    }

    private static String dI(String str) {
        return Thread.currentThread().getName() + "[" + aBI + ":" + aBJ + ":" + aBK + "]" + str;
    }

    private static void b(StackTraceElement[] stackTraceElementArr) {
        aBI = stackTraceElementArr[1].getFileName();
        aBJ = stackTraceElementArr[1].getMethodName();
        aBK = stackTraceElementArr[1].getLineNumber();
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
        if (aBL) {
            b(new Throwable().getStackTrace());
            Log.e("PaySdk", h(str), th);
        }
    }

    public static void j(Object... objArr) {
        if (aBL) {
            b(new Throwable().getStackTrace());
            Log.d("PaySdk", h(objArr));
        }
    }
}
