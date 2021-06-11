package com.alipay.sdk.app.statistic;

import android.content.Context;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1815a = "alipay_cashier_statistic_record";

    /* renamed from: b  reason: collision with root package name */
    public static c f1816b;

    public static void a(Context context) {
        if (f1816b != null) {
            return;
        }
        f1816b = new c(context);
    }

    public static synchronized void b(Context context, String str) {
        synchronized (a.class) {
            if (f1816b == null) {
                return;
            }
            a(context, f1816b.a(str));
            f1816b = null;
        }
    }

    public static void a(Context context, String str) {
        new Thread(new b(context, str)).start();
    }

    public static void a(String str, Throwable th) {
        if (f1816b == null || th == null || th.getClass() == null) {
            return;
        }
        f1816b.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(String str, String str2, Throwable th, String str3) {
        c cVar = f1816b;
        if (cVar == null) {
            return;
        }
        cVar.a(str, str2, th, str3);
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar = f1816b;
        if (cVar == null) {
            return;
        }
        cVar.a(str, str2, th);
    }

    public static void a(String str, String str2, String str3) {
        c cVar = f1816b;
        if (cVar == null) {
            return;
        }
        cVar.a(str, str2, str3);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            c cVar = new c(context);
            cVar.a(str, str2, str3);
            a(context, cVar.a(""));
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
