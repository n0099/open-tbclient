package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes6.dex */
public class d {
    private static String bGJ = null;
    private static String bGK = null;
    private static int bGL = 0;
    public static boolean bGM = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        bGJ = stackTraceElementArr[1].getFileName();
        bGK = stackTraceElementArr[1].getMethodName();
        bGL = stackTraceElementArr[1].getLineNumber();
    }

    private static String dP(String str) {
        return Thread.currentThread().getName() + "[" + bGJ + ":" + bGK + ":" + bGL + "]" + str;
    }

    public static void info(String str) {
        if (!bGM) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void a(Object... objArr) {
        if (bGM) {
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
        return dP(sb.toString());
    }

    public static void a(String str, Throwable th) {
        if (bGM) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(str), th);
        }
    }
}
