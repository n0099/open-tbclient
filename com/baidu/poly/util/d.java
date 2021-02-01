package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes4.dex */
public class d {
    private static String coX = null;
    private static String coY = null;
    private static int coZ = 0;
    public static boolean cpa = true;

    private static void b(StackTraceElement[] stackTraceElementArr) {
        coX = stackTraceElementArr[1].getFileName();
        coY = stackTraceElementArr[1].getMethodName();
        coZ = stackTraceElementArr[1].getLineNumber();
    }

    public static void info(String str) {
        if (!cpa) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    private static String t(String str) {
        return Thread.currentThread().getName() + "[" + coX + ":" + coY + ":" + coZ + "]" + str;
    }

    public static void a(Object... objArr) {
        if (cpa) {
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
        if (cpa) {
            b(new Throwable().getStackTrace());
            Log.e("CashierSdk", m(str), th);
        }
    }
}
