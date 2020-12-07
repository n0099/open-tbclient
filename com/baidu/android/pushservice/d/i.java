package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f1060a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public String i;
    public boolean j;
    public boolean k;

    public i() {
        this.f1060a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = false;
        this.i = "";
        this.j = true;
    }

    public i(Intent intent) {
        this.f1060a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = false;
        this.i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = intent.getStringExtra("pkg_name");
        }
        this.c = intent.getStringExtra("access_token");
        this.g = intent.getStringExtra("secret_key");
        this.f1060a = intent.getStringExtra("method");
        this.b = intent.getStringExtra("method_type");
        this.e = intent.getStringExtra("appid");
        this.h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        return "method=" + this.f1060a + ", accessToken=" + this.c + ", packageName=" + this.d + ", appId=" + this.e + ", userId=" + this.f;
    }
}
