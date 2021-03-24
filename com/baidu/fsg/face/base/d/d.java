package com.baidu.fsg.face.base.d;

import android.util.Log;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5605a = "SAPI_BIOMETRIC";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5606b = "%1$s\n%2$s";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f5607c = false;

    public static void a(boolean z) {
        f5607c = z;
    }

    public static void b(String str, Object... objArr) {
        a(4, null, str, objArr);
    }

    public static void c(String str, Object... objArr) {
        a(5, null, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        a(6, null, str, objArr);
    }

    public static void a(String str, Object... objArr) {
        a(3, null, str, objArr);
    }

    public static void a(Throwable th) {
        a(6, th, null, new Object[0]);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        a(6, th, str, objArr);
    }

    public static void a(int i, Throwable th, String str, Object... objArr) {
        if (f5607c) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format("%1$s\n%2$s", str, Log.getStackTraceString(th));
            }
            Log.println(i, "SAPI_BIOMETRIC", str);
        }
    }
}
