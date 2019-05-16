package com.baidu.poly.util;

import android.util.Log;
/* loaded from: classes2.dex */
public class b {
    private static String ahn;
    private static String aho;
    private static int ahp;
    private static boolean ahq = true;

    public static void enable(boolean z) {
        ahq = z;
    }

    private static String cS(String str) {
        return Thread.currentThread().getName() + "[" + ahn + ":" + aho + ":" + ahp + "]" + str;
    }

    private static void b(StackTraceElement[] stackTraceElementArr) {
        ahn = stackTraceElementArr[1].getFileName();
        aho = stackTraceElementArr[1].getMethodName();
        ahp = stackTraceElementArr[1].getLineNumber();
    }

    private static String j(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return cS(sb.toString());
    }

    public static void f(String str, Throwable th) {
        if (ahq) {
            b(new Throwable().getStackTrace());
            Log.e("PaySdk", j(str), th);
        }
    }

    public static void k(Object... objArr) {
        if (ahq) {
            b(new Throwable().getStackTrace());
            Log.d("PaySdk", j(objArr));
        }
    }
}
