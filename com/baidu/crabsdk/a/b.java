package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f4797c;

    /* renamed from: a  reason: collision with root package name */
    public c f4798a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4799b = false;

    public b(Context context) {
        this.f4798a = c.b(context);
    }

    public static b a(Context context) {
        return b(context);
    }

    public static b b(Context context) {
        if (f4797c == null) {
            synchronized (b.class) {
                if (f4797c == null) {
                    f4797c = new b(context);
                }
            }
        }
        return f4797c;
    }

    public static b c() {
        return f4797c;
    }

    public final void d() {
        if (this.f4799b) {
            com.baidu.crabsdk.c.a.b("Block monitoring has already started!");
            return;
        }
        this.f4799b = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.f4798a.f4803a);
            com.baidu.crabsdk.c.a.b("Start main-thread block monitoring!");
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e2);
        }
    }

    public final void e() {
        String str;
        if (this.f4799b) {
            this.f4799b = false;
            Looper.getMainLooper().setMessageLogging(null);
            this.f4798a.f4804b.d();
            str = "Stop main-thread block monitoring!";
        } else {
            str = "Block monitoring is not enabled!";
        }
        com.baidu.crabsdk.c.a.b(str);
    }
}
