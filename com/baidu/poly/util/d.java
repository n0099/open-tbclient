package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes6.dex */
public class d {
    private static String bGF = null;
    private static String bGG = null;
    private static int bGH = 0;
    public static boolean bGI = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        bGF = stackTraceElementArr[1].getFileName();
        bGG = stackTraceElementArr[1].getMethodName();
        bGH = stackTraceElementArr[1].getLineNumber();
    }

    private static String dO(String str) {
        return Thread.currentThread().getName() + "[" + bGF + ":" + bGG + ":" + bGH + "]" + str;
    }

    public static void info(String str) {
        if (!bGI) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void a(Object... objArr) {
        if (bGI) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(objArr));
        }
    }

    private static String l(Object... objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return dO(sb.toString());
    }

    public static void a(String str, Throwable th) {
        if (bGI) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(str), th);
        }
    }
}
