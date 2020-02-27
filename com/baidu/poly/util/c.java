package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes11.dex */
public class c {
    private static String aRY = null;
    private static String aRZ = null;
    private static int aSa = 0;
    public static boolean aSb = true;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        aRY = stackTraceElementArr[1].getFileName();
        aRZ = stackTraceElementArr[1].getMethodName();
        aSa = stackTraceElementArr[1].getLineNumber();
    }

    private static String eR(String str) {
        return Thread.currentThread().getName() + "[" + aRY + ":" + aRZ + ":" + aSa + "]" + str;
    }

    private static String h(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return eR(sb.toString());
    }

    public static void info(String str) {
        if (!aSb) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void j(Object... objArr) {
        if (aSb) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (aSb) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(str), th);
        }
    }
}
