package com.baidu.fsg.face.base.d;

import android.util.Log;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2089a = "SAPI_BIOMETRIC";

    /* renamed from: b  reason: collision with root package name */
    private static final String f2090b = "%1$s\n%2$s";
    private static boolean c = false;

    private d() {
    }

    public static void a(boolean z) {
        c = z;
    }

    public static void a(String str, Object... objArr) {
        a(3, null, str, objArr);
    }

    public static void b(String str, Object... objArr) {
        a(4, null, str, objArr);
    }

    public static void c(String str, Object... objArr) {
        a(5, null, str, objArr);
    }

    public static void a(Throwable th) {
        a(6, th, null, new Object[0]);
    }

    public static void d(String str, Object... objArr) {
        a(6, null, str, objArr);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        a(6, th, str, objArr);
    }

    private static void a(int i, Throwable th, String str, Object... objArr) {
        if (c) {
            String format = objArr.length > 0 ? String.format(str, objArr) : str;
            if (th != null) {
                if (format == null) {
                    format = th.getMessage();
                }
                format = String.format(f2090b, format, Log.getStackTraceString(th));
            }
            Log.println(i, f2089a, format);
        }
    }
}
