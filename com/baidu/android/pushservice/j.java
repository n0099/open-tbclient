package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class j {
    private static j a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Context f;

    private j(Context context) {
        this.d = PushSettings.c(context);
        this.b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.e = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.c = PushSettings.b(context);
        }
        this.f = context;
    }

    public static j a(Context context) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j(context);
                }
            }
        }
        return a;
    }

    public String a() {
        return this.b;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.b = str;
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
        if (TextUtils.isEmpty(this.b)) {
            this.b = PushSettings.a(this.f);
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = PushSettings.c(this.f);
        }
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.d)) ? false : true;
    }
}
