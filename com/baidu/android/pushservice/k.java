package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static k f3486a;

    /* renamed from: b  reason: collision with root package name */
    public String f3487b;

    /* renamed from: c  reason: collision with root package name */
    public String f3488c;

    /* renamed from: d  reason: collision with root package name */
    public String f3489d;

    /* renamed from: e  reason: collision with root package name */
    public String f3490e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3491f;

    public k(Context context) {
        this.f3489d = PushSettings.c(context);
        this.f3487b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f3490e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f3488c = PushSettings.b(context);
        }
        this.f3491f = context;
    }

    public static k a(Context context) {
        if (f3486a == null) {
            synchronized (k.class) {
                if (f3486a == null) {
                    f3486a = new k(context);
                }
            }
        }
        return f3486a;
    }

    public String a() {
        return this.f3487b;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.f3487b = str;
        this.f3489d = str2;
        this.f3488c = str3;
        this.f3490e = str4;
        PushSettings.a(this.f3491f, str, str3);
        PushSettings.a(this.f3491f, str2);
    }

    public String b() {
        return this.f3489d;
    }

    public String c() {
        return this.f3488c;
    }

    public String d() {
        return this.f3490e;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.f3487b)) {
            this.f3487b = PushSettings.a(this.f3491f);
        }
        if (TextUtils.isEmpty(this.f3489d)) {
            this.f3489d = PushSettings.c(this.f3491f);
        }
        return (TextUtils.isEmpty(this.f3487b) || TextUtils.isEmpty(this.f3489d)) ? false : true;
    }
}
