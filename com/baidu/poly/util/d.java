package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes9.dex */
public class d {
    private static String bBb = null;
    private static String bBc = null;
    private static int bBd = 0;
    public static boolean bBe = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        bBb = stackTraceElementArr[1].getFileName();
        bBc = stackTraceElementArr[1].getMethodName();
        bBd = stackTraceElementArr[1].getLineNumber();
    }

    private static String dC(String str) {
        return Thread.currentThread().getName() + "[" + bBb + ":" + bBc + ":" + bBd + "]" + str;
    }

    public static void info(String str) {
        if (!bBe) {
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
        return dC(sb.toString());
    }

    public static void l(Object... objArr) {
        if (bBe) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (bBe) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(str), th);
        }
    }
}
