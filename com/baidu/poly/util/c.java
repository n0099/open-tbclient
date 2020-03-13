package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes11.dex */
public class c {
    private static String aSa = null;
    private static String aSb = null;
    private static int aSc = 0;
    public static boolean aSd = true;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        aSa = stackTraceElementArr[1].getFileName();
        aSb = stackTraceElementArr[1].getMethodName();
        aSc = stackTraceElementArr[1].getLineNumber();
    }

    private static String eR(String str) {
        return Thread.currentThread().getName() + "[" + aSa + ":" + aSb + ":" + aSc + "]" + str;
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
        if (!aSd) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void j(Object... objArr) {
        if (aSd) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (aSd) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(str), th);
        }
    }
}
