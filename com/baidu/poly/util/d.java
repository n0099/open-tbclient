package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes19.dex */
public class d {
    private static String cit = null;
    private static String ciu = null;
    private static int civ = 0;
    public static boolean ciw = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        cit = stackTraceElementArr[1].getFileName();
        ciu = stackTraceElementArr[1].getMethodName();
        civ = stackTraceElementArr[1].getLineNumber();
    }

    private static String ea(String str) {
        return Thread.currentThread().getName() + "[" + cit + ":" + ciu + ":" + civ + "]" + str;
    }

    public static void info(String str) {
        if (!ciw) {
            return;
        }
        Log.i("CashierSdk", str);
    }

    public static void a(Object... objArr) {
        if (ciw) {
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
        return ea(sb.toString());
    }

    public static void a(String str, Throwable th) {
        if (ciw) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", l(str), th);
        }
    }
}
