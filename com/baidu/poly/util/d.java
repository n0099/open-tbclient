package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes6.dex */
public class d {
    private static String bXQ = null;
    private static String bXR = null;
    private static int bXS = 0;
    public static boolean bXT = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        bXQ = stackTraceElementArr[1].getFileName();
        bXR = stackTraceElementArr[1].getMethodName();
        bXS = stackTraceElementArr[1].getLineNumber();
    }

    private static String dW(String str) {
        return Thread.currentThread().getName() + "[" + bXQ + ":" + bXR + ":" + bXS + "]" + str;
    }

    public static void info(String str) {
        if (!bXT) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void a(Object... objArr) {
        if (bXT) {
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
        if (bXT) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(str), th);
        }
    }
}
