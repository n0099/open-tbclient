package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static k f3415a;

    /* renamed from: b  reason: collision with root package name */
    public String f3416b;

    /* renamed from: c  reason: collision with root package name */
    public String f3417c;

    /* renamed from: d  reason: collision with root package name */
    public String f3418d;

    /* renamed from: e  reason: collision with root package name */
    public String f3419e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3420f;

    public k(Context context) {
        this.f3418d = PushSettings.c(context);
        this.f3416b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f3419e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f3417c = PushSettings.b(context);
        }
        this.f3420f = context;
    }

    public static k a(Context context) {
        if (f3415a == null) {
            synchronized (k.class) {
                if (f3415a == null) {
                    f3415a = new k(context);
                }
            }
        }
        return f3415a;
    }

    public String a() {
        return this.f3416b;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.f3416b = str;
        this.f3418d = str2;
        this.f3417c = str3;
        this.f3419e = str4;
        PushSettings.a(this.f3420f, str, str3);
        PushSettings.a(this.f3420f, str2);
    }

    public String b() {
        return this.f3418d;
    }

    public String c() {
        return this.f3417c;
    }

    public String d() {
        return this.f3419e;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.f3416b)) {
            this.f3416b = PushSettings.a(this.f3420f);
        }
        if (TextUtils.isEmpty(this.f3418d)) {
            this.f3418d = PushSettings.c(this.f3420f);
        }
        return (TextUtils.isEmpty(this.f3416b) || TextUtils.isEmpty(this.f3418d)) ? false : true;
    }
}
