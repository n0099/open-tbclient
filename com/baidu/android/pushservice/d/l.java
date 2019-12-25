package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
/* loaded from: classes5.dex */
public class l {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public String l;
    public boolean m;

    public l() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = false;
        this.l = "";
        this.m = true;
    }

    public l(Intent intent) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = false;
        this.l = "";
        this.m = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.e = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.e)) {
            this.e = intent.getStringExtra(PushConstants.PACKAGE_NAME);
        }
        this.d = intent.getStringExtra("access_token");
        this.i = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        this.b = intent.getStringExtra("method_type");
        this.c = intent.getStringExtra("method_version");
        this.h = intent.getStringExtra("bduss");
        this.f = intent.getStringExtra("appid");
        this.j = intent.getStringExtra("is_baidu_internal_bind");
        this.k = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.l = intent.getStringExtra("push_proxy");
        this.m = intent.getBooleanExtra("should_notify_user", true);
    }

    public String toString() {
        return "method=" + this.a + ", accessToken=" + this.d + ", packageName=" + this.e + ", appId=" + this.f + ", userId=" + this.g + ", rsaBduss=" + this.h + ", isInternalBind=" + this.j;
    }
}
