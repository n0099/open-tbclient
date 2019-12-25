package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.pushservice.d.a;
import com.baidu.android.pushservice.d.y;
/* loaded from: classes5.dex */
public final class i {
    private static i a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Thread f;
    private boolean g;
    private Context h;

    private i(Context context) {
        this.d = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_token");
        this.b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.e = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.c = PushSettings.b(context);
        }
        this.g = false;
        this.h = context;
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (a == null) {
                a = new i(context);
            }
            iVar = a;
        }
        return iVar;
    }

    public String a() {
        return this.b;
    }

    public void a(Context context, boolean z, a.C0041a c0041a) {
        if (this.f == null || !this.f.isAlive()) {
            y yVar = new y(context, c0041a);
            if (!z) {
                yVar.a(0);
            }
            this.f = new Thread(yVar);
            this.f.start();
        }
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        this.b = str;
        this.d = str2;
        this.c = str3;
        this.e = str4;
        PushSettings.a(this.h, str, str3);
        com.baidu.android.pushservice.i.i.a(this.h, "com.baidu.pushservice.channel_token", str2);
        com.baidu.android.pushservice.i.i.a(this.h, "com.baidu.pushservice.channel_token_new", str4);
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
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.d)) ? false : true;
    }

    public boolean f() {
        try {
            SharedPreferences sharedPreferences = this.h.getSharedPreferences("pushclient", 0);
            if (sharedPreferences.getInt("isFirstReqChannelIDVcode", 0) == a.a()) {
                return false;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("isFirstReqChannelIDVcode", a.a());
            edit.commit();
            return true;
        } catch (Exception e) {
            return true;
        }
    }
}
