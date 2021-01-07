package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static j f1432a;

    /* renamed from: b  reason: collision with root package name */
    private String f1433b;
    private String c;
    private String d;
    private String e;
    private Context f;

    private j(Context context) {
        this.d = PushSettings.c(context);
        this.f1433b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.e = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.c = PushSettings.b(context);
        }
        this.f = context;
    }

    public static j a(Context context) {
        if (f1432a == null) {
            synchronized (j.class) {
                if (f1432a == null) {
                    f1432a = new j(context);
                }
            }
        }
        return f1432a;
    }

    public String a() {
        return this.f1433b;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.f1433b = str;
        this.d = str2;
        this.c = str3;
        this.e = str4;
        PushSettings.a(this.f, str, str3);
        PushSettings.a(this.f, str2);
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.e;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.f1433b)) {
            this.f1433b = PushSettings.a(this.f);
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = PushSettings.c(this.f);
        }
        return (TextUtils.isEmpty(this.f1433b) || TextUtils.isEmpty(this.d)) ? false : true;
    }
}
