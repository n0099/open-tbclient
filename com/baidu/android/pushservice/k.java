package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static k f3414a;

    /* renamed from: b  reason: collision with root package name */
    public String f3415b;

    /* renamed from: c  reason: collision with root package name */
    public String f3416c;

    /* renamed from: d  reason: collision with root package name */
    public String f3417d;

    /* renamed from: e  reason: collision with root package name */
    public String f3418e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3419f;

    public k(Context context) {
        this.f3417d = PushSettings.c(context);
        this.f3415b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f3418e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f3416c = PushSettings.b(context);
        }
        this.f3419f = context;
    }

    public static k a(Context context) {
        if (f3414a == null) {
            synchronized (k.class) {
                if (f3414a == null) {
                    f3414a = new k(context);
                }
            }
        }
        return f3414a;
    }

    public String a() {
        return this.f3415b;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.f3415b = str;
        this.f3417d = str2;
        this.f3416c = str3;
        this.f3418e = str4;
        PushSettings.a(this.f3419f, str, str3);
        PushSettings.a(this.f3419f, str2);
    }

    public String b() {
        return this.f3417d;
    }

    public String c() {
        return this.f3416c;
    }

    public String d() {
        return this.f3418e;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.f3415b)) {
            this.f3415b = PushSettings.a(this.f3419f);
        }
        if (TextUtils.isEmpty(this.f3417d)) {
            this.f3417d = PushSettings.c(this.f3419f);
        }
        return (TextUtils.isEmpty(this.f3415b) || TextUtils.isEmpty(this.f3417d)) ? false : true;
    }
}
