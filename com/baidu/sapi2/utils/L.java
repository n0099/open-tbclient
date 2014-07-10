package com.baidu.sapi2.utils;

import android.util.Log;
/* loaded from: classes.dex */
public final class L {
    private static final String a = "SAPI";
    private static final String b = "%1$s\n%2$s";
    private static boolean c = false;

    private L() {
    }

    public static void enable(boolean z) {
        c = z;
    }

    public static void d(String str, Object... objArr) {
        a(3, null, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        a(4, null, str, objArr);
    }

    public static void w(String str, Object... objArr) {
        a(5, null, str, objArr);
    }

    public static void e(Throwable th) {
        a(6, th, null, new Object[0]);
    }

    public static void e(String str, Object... objArr) {
        a(6, null, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        a(6, th, str, objArr);
    }

    private static void a(int i, Throwable th, String str, Object... objArr) {
        if (c) {
            String format = objArr.length > 0 ? String.format(str, objArr) : str;
            if (th != null) {
                if (format == null) {
                    format = th.getMessage();
                }
                format = String.format(b, format, Log.getStackTraceString(th));
            }
            Log.println(i, a, format);
        }
    }
}
