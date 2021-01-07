package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes4.dex */
public class d {
    private static String cpw = null;
    private static String cpx = null;
    private static int cpy = 0;
    public static boolean cpz = true;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        cpw = stackTraceElementArr[1].getFileName();
        cpx = stackTraceElementArr[1].getMethodName();
        cpy = stackTraceElementArr[1].getLineNumber();
    }

    public static void info(String str) {
        if (!cpz) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    private static String t(String str) {
        return Thread.currentThread().getName() + "[" + cpw + ":" + cpx + ":" + cpy + "]" + str;
    }

    public static void a(Object... objArr) {
        if (cpz) {
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
        if (cpz) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", m(str), th);
        }
    }
}
