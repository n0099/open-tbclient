package com.baidu.android.pushservice.p;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class i {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e = "";
    public String f;
    public boolean g;
    public String h;
    public boolean i;
    public boolean j;

    public i(Intent intent) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.f = "";
        this.g = false;
        this.h = "";
        this.i = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.c = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = intent.getStringExtra("pkg_name");
        }
        this.b = intent.getStringExtra("access_token");
        this.f = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        intent.getStringExtra("method_type");
        this.d = intent.getStringExtra("appid");
        this.g = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.h = intent.getStringExtra("push_proxy");
        this.i = intent.getBooleanExtra("should_notify_user", true);
        this.j = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        return "method=" + this.a + ", accessToken=" + this.b + ", packageName=" + this.c + ", appId=" + this.d + ", userId=" + this.e;
    }
}
