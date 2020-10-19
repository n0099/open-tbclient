package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes6.dex */
public class d {
    private static String bPt = null;
    private static String bPu = null;
    private static int bPv = 0;
    public static boolean bPw = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        bPt = stackTraceElementArr[1].getFileName();
        bPu = stackTraceElementArr[1].getMethodName();
        bPv = stackTraceElementArr[1].getLineNumber();
    }

    private static String dW(String str) {
        return Thread.currentThread().getName() + "[" + bPt + ":" + bPu + ":" + bPv + "]" + str;
    }

    public static void info(String str) {
        if (!bPw) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void a(Object... objArr) {
        if (bPw) {
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
        if (bPw) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(str), th);
        }
    }
}
