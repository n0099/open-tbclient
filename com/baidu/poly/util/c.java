package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes11.dex */
public class c {
    private static String aSn = null;
    private static String aSo = null;
    private static int aSp = 0;
    public static boolean aSq = true;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        aSn = stackTraceElementArr[1].getFileName();
        aSo = stackTraceElementArr[1].getMethodName();
        aSp = stackTraceElementArr[1].getLineNumber();
    }

    private static String eQ(String str) {
        return Thread.currentThread().getName() + "[" + aSn + ":" + aSo + ":" + aSp + "]" + str;
    }

    private static String h(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return eQ(sb.toString());
    }

    public static void info(String str) {
        if (!aSq) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void j(Object... objArr) {
        if (aSq) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (aSq) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", h(str), th);
        }
    }
}
