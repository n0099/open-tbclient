package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes11.dex */
public class c {
    private static String boq = null;
    private static String bor = null;
    public static boolean bos = true;
    private static int md;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        boq = stackTraceElementArr[1].getFileName();
        bor = stackTraceElementArr[1].getMethodName();
        md = stackTraceElementArr[1].getLineNumber();
    }

    private static String fL(String str) {
        return Thread.currentThread().getName() + "[" + boq + ":" + bor + ":" + md + "]" + str;
    }

    public static void info(String str) {
        if (!bos) {
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
        if (bos) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (bos) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(str), th);
        }
    }
}
