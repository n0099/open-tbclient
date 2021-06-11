package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static k f3508a;

    /* renamed from: b  reason: collision with root package name */
    public String f3509b;

    /* renamed from: c  reason: collision with root package name */
    public String f3510c;

    /* renamed from: d  reason: collision with root package name */
    public String f3511d;

    /* renamed from: e  reason: collision with root package name */
    public String f3512e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3513f;

    public k(Context context) {
        this.f3511d = PushSettings.c(context);
        this.f3509b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f3512e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f3510c = PushSettings.b(context);
        }
        this.f3513f = context;
    }

    public static k a(Context context) {
        if (f3508a == null) {
            synchronized (k.class) {
                if (f3508a == null) {
                    f3508a = new k(context);
                }
            }
        }
        return f3508a;
    }

    public String a() {
        return this.f3509b;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.f3509b = str;
        this.f3511d = str2;
        this.f3510c = str3;
        this.f3512e = str4;
        PushSettings.a(this.f3513f, str, str3);
        PushSettings.a(this.f3513f, str2);
    }

    public String b() {
        return this.f3511d;
    }

    public String c() {
        return this.f3510c;
    }

    public String d() {
        return this.f3512e;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.f3509b)) {
            this.f3509b = PushSettings.a(this.f3513f);
        }
        if (TextUtils.isEmpty(this.f3511d)) {
            this.f3511d = PushSettings.c(this.f3513f);
        }
        return (TextUtils.isEmpty(this.f3509b) || TextUtils.isEmpty(this.f3511d)) ? false : true;
    }
}
