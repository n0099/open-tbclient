package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    private static String bvU = null;
    private static String bvV = null;
    private static int bvW = 0;
    public static boolean bvX = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        bvU = stackTraceElementArr[1].getFileName();
        bvV = stackTraceElementArr[1].getMethodName();
        bvW = stackTraceElementArr[1].getLineNumber();
    }

    private static String dw(String str) {
        return Thread.currentThread().getName() + "[" + bvU + ":" + bvV + ":" + bvW + "]" + str;
    }

    public static void info(String str) {
        if (!bvX) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    private static String k(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return dw(sb.toString());
    }

    public static void l(Object... objArr) {
        if (bvX) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (bvX) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(str), th);
        }
    }
}
