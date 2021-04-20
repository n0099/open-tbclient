package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static k f3450a;

    /* renamed from: b  reason: collision with root package name */
    public String f3451b;

    /* renamed from: c  reason: collision with root package name */
    public String f3452c;

    /* renamed from: d  reason: collision with root package name */
    public String f3453d;

    /* renamed from: e  reason: collision with root package name */
    public String f3454e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3455f;

    public k(Context context) {
        this.f3453d = PushSettings.c(context);
        this.f3451b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f3454e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f3452c = PushSettings.b(context);
        }
        this.f3455f = context;
    }

    public static k a(Context context) {
        if (f3450a == null) {
            synchronized (k.class) {
                if (f3450a == null) {
                    f3450a = new k(context);
                }
            }
        }
        return f3450a;
    }

    public String a() {
        return this.f3451b;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.f3451b = str;
        this.f3453d = str2;
        this.f3452c = str3;
        this.f3454e = str4;
        PushSettings.a(this.f3455f, str, str3);
        PushSettings.a(this.f3455f, str2);
    }

    public String b() {
        return this.f3453d;
    }

    public String c() {
        return this.f3452c;
    }

    public String d() {
        return this.f3454e;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.f3451b)) {
            this.f3451b = PushSettings.a(this.f3455f);
        }
        if (TextUtils.isEmpty(this.f3453d)) {
            this.f3453d = PushSettings.c(this.f3455f);
        }
        return (TextUtils.isEmpty(this.f3451b) || TextUtils.isEmpty(this.f3453d)) ? false : true;
    }
}
