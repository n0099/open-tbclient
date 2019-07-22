package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes2.dex */
public class b {
    private static String ahO;
    private static String ahP;
    private static int ahQ;
    private static boolean ahR = true;

    public static void enable(boolean z) {
        ahR = z;
    }

    private static String cW(String str) {
        return Thread.currentThread().getName() + "[" + ahO + ":" + ahP + ":" + ahQ + "]" + str;
    }

    private static void b(StackTraceElement[] stackTraceElementArr) {
        ahO = stackTraceElementArr[1].getFileName();
        ahP = stackTraceElementArr[1].getMethodName();
        ahQ = stackTraceElementArr[1].getLineNumber();
    }

    private static String j(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return cW(sb.toString());
    }

    public static void f(String str, Throwable th) {
        if (ahR) {
            b(new Throwable().getStackTrace());
            Log.e("PaySdk", j(str), th);
        }
    }

    public static void k(Object... objArr) {
        if (ahR) {
            b(new Throwable().getStackTrace());
            Log.d("PaySdk", j(objArr));
        }
    }
}
