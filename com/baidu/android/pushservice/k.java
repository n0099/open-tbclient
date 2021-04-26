package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static k f3485a;

    /* renamed from: b  reason: collision with root package name */
    public String f3486b;

    /* renamed from: c  reason: collision with root package name */
    public String f3487c;

    /* renamed from: d  reason: collision with root package name */
    public String f3488d;

    /* renamed from: e  reason: collision with root package name */
    public String f3489e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3490f;

    public k(Context context) {
        this.f3488d = PushSettings.c(context);
        this.f3486b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f3489e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f3487c = PushSettings.b(context);
        }
        this.f3490f = context;
    }

    public static k a(Context context) {
        if (f3485a == null) {
            synchronized (k.class) {
                if (f3485a == null) {
                    f3485a = new k(context);
                }
            }
        }
        return f3485a;
    }

    public String a() {
        return this.f3486b;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.f3486b = str;
        this.f3488d = str2;
        this.f3487c = str3;
        this.f3489e = str4;
        PushSettings.a(this.f3490f, str, str3);
        PushSettings.a(this.f3490f, str2);
    }

    public String b() {
        return this.f3488d;
    }

    public String c() {
        return this.f3487c;
    }

    public String d() {
        return this.f3489e;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.f3486b)) {
            this.f3486b = PushSettings.a(this.f3490f);
        }
        if (TextUtils.isEmpty(this.f3488d)) {
            this.f3488d = PushSettings.c(this.f3490f);
        }
        return (TextUtils.isEmpty(this.f3486b) || TextUtils.isEmpty(this.f3488d)) ? false : true;
    }
}
