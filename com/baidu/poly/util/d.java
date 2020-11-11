package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes6.dex */
public class d {
    private static String cdC = null;
    private static String cdD = null;
    private static int cdE = 0;
    public static boolean cdF = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        cdC = stackTraceElementArr[1].getFileName();
        cdD = stackTraceElementArr[1].getMethodName();
        cdE = stackTraceElementArr[1].getLineNumber();
    }

    private static String dW(String str) {
        return Thread.currentThread().getName() + "[" + cdC + ":" + cdD + ":" + cdE + "]" + str;
    }

    public static void info(String str) {
        if (!cdF) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void a(Object... objArr) {
        if (cdF) {
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
        return dW(sb.toString());
    }

    public static void a(String str, Throwable th) {
        if (cdF) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(str), th);
        }
    }
}
