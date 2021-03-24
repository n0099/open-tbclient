package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f4650c;

    /* renamed from: a  reason: collision with root package name */
    public c f4651a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4652b = false;

    public b(Context context) {
        this.f4651a = c.b(context);
    }

    public static b a(Context context) {
        return b(context);
    }

    public static b b(Context context) {
        if (f4650c == null) {
            synchronized (b.class) {
                if (f4650c == null) {
                    f4650c = new b(context);
                }
            }
        }
        return f4650c;
    }

    public static b c() {
        return f4650c;
    }

    public final void d() {
        if (this.f4652b) {
            com.baidu.crabsdk.c.a.b("Block monitoring has already started!");
            return;
        }
        this.f4652b = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.f4651a.f4656a);
            com.baidu.crabsdk.c.a.b("Start main-thread block monitoring!");
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e2);
        }
    }

    public final void e() {
        String str;
        if (this.f4652b) {
            this.f4652b = false;
            Looper.getMainLooper().setMessageLogging(null);
            this.f4651a.f4657b.d();
            str = "Stop main-thread block monitoring!";
        } else {
            str = "Block monitoring is not enabled!";
        }
        com.baidu.crabsdk.c.a.b(str);
    }
}
