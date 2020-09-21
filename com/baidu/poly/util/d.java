package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes9.dex */
public class d {
    private static String bIK = null;
    private static String bIL = null;
    private static int bIM = 0;
    public static boolean bIN = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        bIK = stackTraceElementArr[1].getFileName();
        bIL = stackTraceElementArr[1].getMethodName();
        bIM = stackTraceElementArr[1].getLineNumber();
    }

    private static String dR(String str) {
        return Thread.currentThread().getName() + "[" + bIK + ":" + bIL + ":" + bIM + "]" + str;
    }

    public static void info(String str) {
        if (!bIN) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void a(Object... objArr) {
        if (bIN) {
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
        return dR(sb.toString());
    }

    public static void a(String str, Throwable th) {
        if (bIN) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(str), th);
        }
    }
}
