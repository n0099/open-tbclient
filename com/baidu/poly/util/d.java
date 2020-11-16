package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes6.dex */
public class d {
    private static String cbP = null;
    private static String cbQ = null;
    private static int cbR = 0;
    public static boolean cbS = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        cbP = stackTraceElementArr[1].getFileName();
        cbQ = stackTraceElementArr[1].getMethodName();
        cbR = stackTraceElementArr[1].getLineNumber();
    }

    private static String dY(String str) {
        return Thread.currentThread().getName() + "[" + cbP + ":" + cbQ + ":" + cbR + "]" + str;
    }

    public static void info(String str) {
        if (!cbS) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void a(Object... objArr) {
        if (cbS) {
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
        return dY(sb.toString());
    }

    public static void a(String str, Throwable th) {
        if (cbS) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(str), th);
        }
    }
}
