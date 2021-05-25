package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static k f3489a;

    /* renamed from: b  reason: collision with root package name */
    public String f3490b;

    /* renamed from: c  reason: collision with root package name */
    public String f3491c;

    /* renamed from: d  reason: collision with root package name */
    public String f3492d;

    /* renamed from: e  reason: collision with root package name */
    public String f3493e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3494f;

    public k(Context context) {
        this.f3492d = PushSettings.c(context);
        this.f3490b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f3493e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f3491c = PushSettings.b(context);
        }
        this.f3494f = context;
    }

    public static k a(Context context) {
        if (f3489a == null) {
            synchronized (k.class) {
                if (f3489a == null) {
                    f3489a = new k(context);
                }
            }
        }
        return f3489a;
    }

    public String a() {
        return this.f3490b;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.f3490b = str;
        this.f3492d = str2;
        this.f3491c = str3;
        this.f3493e = str4;
        PushSettings.a(this.f3494f, str, str3);
        PushSettings.a(this.f3494f, str2);
    }

    public String b() {
        return this.f3492d;
    }

    public String c() {
        return this.f3491c;
    }

    public String d() {
        return this.f3493e;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.f3490b)) {
            this.f3490b = PushSettings.a(this.f3494f);
        }
        if (TextUtils.isEmpty(this.f3492d)) {
            this.f3492d = PushSettings.c(this.f3494f);
        }
        return (TextUtils.isEmpty(this.f3490b) || TextUtils.isEmpty(this.f3492d)) ? false : true;
    }
}
