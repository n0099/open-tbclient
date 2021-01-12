package com.baidu.lbsapi.auth;

import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes6.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2483a = false;

    /* renamed from: b  reason: collision with root package name */
    private static String f2484b = "BaiduApiAuth";

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    public static void a(String str) {
        if (!f2483a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.d(f2484b, a() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str);
    }

    public static void b(String str) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(f2484b, str);
    }

    public static void c(String str) {
        if (!f2483a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.e(f2484b, a() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str);
    }
}
