package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.pushservice.e.a;
import com.baidu.android.pushservice.e.x;
import com.baidu.android.pushservice.j.n;
/* loaded from: classes2.dex */
public final class j {
    private static j a;
    private String b;
    private String c;
    private Thread d = null;
    private boolean e = false;
    private Context f;

    private j(Context context) {
        this.b = null;
        this.c = null;
        this.c = n.a(context, "com.baidu.pushservice.channel_token");
        this.b = PushSettings.a(context);
        this.f = context;
    }

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j(context);
            }
            jVar = a;
        }
        return jVar;
    }

    public String a() {
        return this.b;
    }

    public void a(Context context, boolean z, a.C0019a c0019a) {
        if (this.d == null || !this.d.isAlive()) {
            x xVar = new x(context, c0019a);
            if (!z) {
                xVar.a(0);
            }
            this.d = new Thread(xVar);
            this.d.start();
        }
    }

    public synchronized void a(String str, String str2) {
        this.b = str;
        this.c = str2;
        PushSettings.a(this.f, str);
        n.a(this.f, "com.baidu.pushservice.channel_token", str2);
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            com.baidu.android.pushservice.g.a.c("TokenManager", "isChannelTokenAvailable false mChannelId = " + this.b + " mChannelToken =  " + this.c);
            return false;
        }
        com.baidu.android.pushservice.g.a.c("TokenManager", "isChannelTokenAvailable true mChannelId = " + this.b + " mChannelToken =  " + this.c);
        return true;
    }

    public boolean d() {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = this.f.getSharedPreferences("pushclient", 0);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("TokenManager", e);
        }
        if (sharedPreferences.getInt("isFirstReqChannelIDVcode", 0) == a.a()) {
            com.baidu.android.pushservice.g.a.c("TokenManager", "not first REQChannelID");
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("isFirstReqChannelIDVcode", a.a());
        edit.commit();
        com.baidu.android.pushservice.g.a.c("TokenManager", " first REQChannelID");
        return true;
    }
}
