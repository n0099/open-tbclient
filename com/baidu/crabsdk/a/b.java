package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f4651c;

    /* renamed from: a  reason: collision with root package name */
    public c f4652a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4653b = false;

    public b(Context context) {
        this.f4652a = c.b(context);
    }

    public static b a(Context context) {
        return b(context);
    }

    public static b b(Context context) {
        if (f4651c == null) {
            synchronized (b.class) {
                if (f4651c == null) {
                    f4651c = new b(context);
                }
            }
        }
        return f4651c;
    }

    public static b c() {
        return f4651c;
    }

    public final void d() {
        if (this.f4653b) {
            com.baidu.crabsdk.c.a.b("Block monitoring has already started!");
            return;
        }
        this.f4653b = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.f4652a.f4657a);
            com.baidu.crabsdk.c.a.b("Start main-thread block monitoring!");
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e2);
        }
    }

    public final void e() {
        String str;
        if (this.f4653b) {
            this.f4653b = false;
            Looper.getMainLooper().setMessageLogging(null);
            this.f4652a.f4658b.d();
            str = "Stop main-thread block monitoring!";
        } else {
            str = "Block monitoring is not enabled!";
        }
        com.baidu.crabsdk.c.a.b(str);
    }
}
