package com.baidu.mapsdkplatform.comapi.synchronization.d;

import android.util.Log;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7807a = true;

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + ": Line " + stackTraceElement.getLineNumber();
    }

    public static void a(String str, String str2) {
        if (f7807a) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f7807a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(boolean z) {
        f7807a = z;
    }

    public static String b() {
        return new Throwable().getStackTrace()[2].getMethodName();
    }

    public static void b(String str, String str2) {
        if (f7807a) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2) {
        Log.d(str + "-" + b() + "-" + a(), str2);
    }
}
