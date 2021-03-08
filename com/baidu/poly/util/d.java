package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes14.dex */
public class d {
    private static String cqA = null;
    private static int cqB = 0;
    public static boolean cqC = true;
    private static String cqz;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        cqz = stackTraceElementArr[1].getFileName();
        cqA = stackTraceElementArr[1].getMethodName();
        cqB = stackTraceElementArr[1].getLineNumber();
    }

    private static String dO(String str) {
        return Thread.currentThread().getName() + "[" + cqz + ":" + cqA + ":" + cqB + "]" + str;
    }

    public static void info(String str) {
        if (!cqC) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void a(Object... objArr) {
        if (cqC) {
            b(new Throwable().getStackTrace());
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
        if (cqC) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(str), th);
        }
    }
}
