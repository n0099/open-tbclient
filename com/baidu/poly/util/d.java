package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes3.dex */
public class d {
    private static String ckG = null;
    private static String ckH = null;
    private static int ckI = 0;
    public static boolean ckJ = true;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        ckG = stackTraceElementArr[1].getFileName();
        ckH = stackTraceElementArr[1].getMethodName();
        ckI = stackTraceElementArr[1].getLineNumber();
    }

    public static void info(String str) {
        if (!ckJ) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    private static String t(String str) {
        return Thread.currentThread().getName() + "[" + ckG + ":" + ckH + ":" + ckI + "]" + str;
    }

    public static void a(Object... objArr) {
        if (ckJ) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", m(objArr));
        }
    }

    private static String m(Object... objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return t(sb.toString());
    }

    public static void a(String str, Throwable th) {
        if (ckJ) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", m(str), th);
        }
    }
}
