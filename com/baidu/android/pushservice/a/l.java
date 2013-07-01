package com.baidu.android.pushservice.a;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public String f299a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public l() {
        this.f299a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
    }

    public l(Intent intent) {
        this.f299a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP);
        if (pendingIntent != null) {
            this.e = pendingIntent.getTargetPackage();
        }
        this.d = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        this.i = intent.getStringExtra(PushConstants.EXTRA_API_KEY);
        this.f299a = intent.getStringExtra(PushConstants.EXTRA_METHOD);
        this.b = intent.getStringExtra("method_type");
        this.c = intent.getStringExtra("method_version");
        this.h = intent.getStringExtra("bduss");
        this.f = intent.getStringExtra("appid");
    }

    public String toString() {
        return "method=" + this.f299a + ", rsarsaAccessToken=" + this.d + ", packageName=" + this.e + ", appId=" + this.f + ", userId=" + this.g + ", rsaBduss=" + this.h;
    }
}
