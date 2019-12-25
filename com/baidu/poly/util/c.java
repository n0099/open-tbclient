package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes9.dex */
public class c {
    private static String aMH = null;
    private static String aMI = null;
    private static int aMJ = 0;
    public static boolean aMK = true;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        aMH = stackTraceElementArr[1].getFileName();
        aMI = stackTraceElementArr[1].getMethodName();
        aMJ = stackTraceElementArr[1].getLineNumber();
    }

    private static String ey(String str) {
        return Thread.currentThread().getName() + "[" + aMH + ":" + aMI + ":" + aMJ + "]" + str;
    }

    private static String h(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return ey(sb.toString());
    }

    public static void info(String str) {
        if (!aMK) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void j(Object... objArr) {
        if (aMK) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (aMK) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(str), th);
        }
    }
}
