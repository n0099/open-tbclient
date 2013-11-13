package com.baidu.android.pushservice.a;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public String f690a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public l() {
        this.f690a = "";
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
        this.f690a = "";
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
        this.d = intent.getStringExtra("access_token");
        this.i = intent.getStringExtra(PushConstants.EXTRA_API_KEY);
        this.f690a = intent.getStringExtra(PushConstants.EXTRA_METHOD);
        this.b = intent.getStringExtra("method_type");
        this.c = intent.getStringExtra("method_version");
        this.h = intent.getStringExtra(SocialConstants.PARAM_BDUSS);
        this.f = intent.getStringExtra("appid");
    }

    public String toString() {
        return "method=" + this.f690a + ", rsarsaAccessToken=" + this.d + ", packageName=" + this.e + ", appId=" + this.f + ", userId=" + this.g + ", rsaBduss=" + this.h;
    }
}
