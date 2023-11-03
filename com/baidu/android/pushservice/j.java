package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class j {
    public static j f;
    public String a;
    public String b;
    public String c;
    public String d;
    public Context e;

    public j(Context context) {
        this.c = PushSettings.c(context);
        this.a = PushSettings.b(context);
        if (com.baidu.android.pushservice.l.d.o(context)) {
            this.d = com.baidu.android.pushservice.a0.i.c(context, "com.baidu.pushservice.channel_token_new");
            this.b = PushSettings.d(context);
        }
        this.e = context;
    }

    public static j a(Context context) {
        if (f == null) {
            synchronized (j.class) {
                if (f == null) {
                    f = new j(context);
                }
            }
        }
        return f;
    }

    public String a() {
        return this.a;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.a = str;
        this.c = str2;
        this.b = str3;
        this.d = str4;
        PushSettings.a(this.e, str, str3);
        PushSettings.b(this.e, str2);
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = PushSettings.b(this.e);
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = PushSettings.c(this.e);
        }
        return (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.c)) ? false : true;
    }
}
