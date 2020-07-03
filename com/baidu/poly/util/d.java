package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    private static String bAL = null;
    private static String bAM = null;
    private static int bAN = 0;
    public static boolean bAO = true;

    private static void a(StackTraceElement[] stackTraceElementArr) {
        bAL = stackTraceElementArr[1].getFileName();
        bAM = stackTraceElementArr[1].getMethodName();
        bAN = stackTraceElementArr[1].getLineNumber();
    }

    private static String dy(String str) {
        return Thread.currentThread().getName() + "[" + bAL + ":" + bAM + ":" + bAN + "]" + str;
    }

    public static void info(String str) {
        if (!bAO) {
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
        return dy(sb.toString());
    }

    public static void l(Object... objArr) {
        if (bAO) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (bAO) {
            a(new Throwable().getStackTrace());
            Log.e("CashierSdk", k(str), th);
        }
    }
}
