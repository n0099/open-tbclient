package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes11.dex */
public class c {
    private static String aRZ = null;
    private static String aSa = null;
    private static int aSb = 0;
    public static boolean aSc = true;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        aRZ = stackTraceElementArr[1].getFileName();
        aSa = stackTraceElementArr[1].getMethodName();
        aSb = stackTraceElementArr[1].getLineNumber();
    }

    private static String eR(String str) {
        return Thread.currentThread().getName() + "[" + aRZ + ":" + aSa + ":" + aSb + "]" + str;
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
        if (!aSc) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void j(Object... objArr) {
        if (aSc) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (aSc) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(str), th);
        }
    }
}
