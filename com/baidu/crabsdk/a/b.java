package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f4686c;

    /* renamed from: a  reason: collision with root package name */
    public c f4687a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4688b = false;

    public b(Context context) {
        this.f4687a = c.b(context);
    }

    public static b a(Context context) {
        return b(context);
    }

    public static b b(Context context) {
        if (f4686c == null) {
            synchronized (b.class) {
                if (f4686c == null) {
                    f4686c = new b(context);
                }
            }
        }
        return f4686c;
    }

    public static b c() {
        return f4686c;
    }

    public final void d() {
        if (this.f4688b) {
            com.baidu.crabsdk.c.a.b("Block monitoring has already started!");
            return;
        }
        this.f4688b = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.f4687a.f4692a);
            com.baidu.crabsdk.c.a.b("Start main-thread block monitoring!");
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e2);
        }
    }

    public final void e() {
        String str;
        if (this.f4688b) {
            this.f4688b = false;
            Looper.getMainLooper().setMessageLogging(null);
            this.f4687a.f4693b.d();
            str = "Stop main-thread block monitoring!";
        } else {
            str = "Block monitoring is not enabled!";
        }
        com.baidu.crabsdk.c.a.b(str);
    }
}
