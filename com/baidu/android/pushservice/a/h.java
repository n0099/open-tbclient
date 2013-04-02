package com.baidu.android.pushservice.a;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;
/* loaded from: classes.dex */
public class h {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public h() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
    }

    public h(Intent intent) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP);
        if (pendingIntent != null) {
            this.c = pendingIntent.getTargetPackage();
        }
        this.b = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        this.a = intent.getStringExtra(PushConstants.EXTRA_METHOD);
        this.f = intent.getStringExtra("bduss");
        this.d = intent.getStringExtra("appid");
    }

    public String toString() {
        return "method=" + this.a + ", rsarsaAccessToken=" + this.b + ", packageName=" + this.c + ", appId=" + this.d + ", userId=" + this.e + ", rsaBduss=" + this.f;
    }
}
