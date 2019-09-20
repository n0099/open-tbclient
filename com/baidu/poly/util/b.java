package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes2.dex */
public class b {
    private static String ail;
    private static String aim;
    private static int ain;
    private static boolean aio = true;

    public static void enable(boolean z) {
        aio = z;
    }

    private static String cY(String str) {
        return Thread.currentThread().getName() + "[" + ail + ":" + aim + ":" + ain + "]" + str;
    }

    private static void b(StackTraceElement[] stackTraceElementArr) {
        ail = stackTraceElementArr[1].getFileName();
        aim = stackTraceElementArr[1].getMethodName();
        ain = stackTraceElementArr[1].getLineNumber();
    }

    private static String j(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return cY(sb.toString());
    }

    public static void f(String str, Throwable th) {
        if (aio) {
            b(new Throwable().getStackTrace());
            Log.e("PaySdk", j(str), th);
        }
    }

    public static void k(Object... objArr) {
        if (aio) {
            b(new Throwable().getStackTrace());
            Log.d("PaySdk", j(objArr));
        }
    }
}
