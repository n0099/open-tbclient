package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes11.dex */
public class c {
    private static String bov = null;
    private static String bow = null;
    public static boolean box = true;
    private static int md;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        bov = stackTraceElementArr[1].getFileName();
        bow = stackTraceElementArr[1].getMethodName();
        md = stackTraceElementArr[1].getLineNumber();
    }

    private static String fL(String str) {
        return Thread.currentThread().getName() + "[" + bov + ":" + bow + ":" + md + "]" + str;
    }

    public static void info(String str) {
        if (!box) {
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
        return fL(sb.toString());
    }

    public static void l(Object... objArr) {
        if (box) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (box) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(str), th);
        }
    }
}
