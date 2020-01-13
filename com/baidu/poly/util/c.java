package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes10.dex */
public class c {
    private static String aNA = null;
    private static int aNB = 0;
    public static boolean aNC = true;
    private static String aNz;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        aNz = stackTraceElementArr[1].getFileName();
        aNA = stackTraceElementArr[1].getMethodName();
        aNB = stackTraceElementArr[1].getLineNumber();
    }

    private static String eB(String str) {
        return Thread.currentThread().getName() + "[" + aNz + ":" + aNA + ":" + aNB + "]" + str;
    }

    private static String h(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return eB(sb.toString());
    }

    public static void info(String str) {
        if (!aNC) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void j(Object... objArr) {
        if (aNC) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (aNC) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(str), th);
        }
    }
}
