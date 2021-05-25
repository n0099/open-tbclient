package com.baidu.lbsapi.auth;

import android.util.Log;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6293a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f6294b = "BaiduApiAuth";

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    public static void a(String str) {
        if (!f6293a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        String str2 = f6294b;
        Log.d(str2, a() + ";" + str);
    }

    public static void b(String str) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(f6294b, str);
    }

    public static void c(String str) {
        if (!f6293a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        String str2 = f6294b;
        Log.e(str2, a() + ";" + str);
    }
}
