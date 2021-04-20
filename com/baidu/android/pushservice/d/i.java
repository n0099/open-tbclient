package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f2994a;

    /* renamed from: b  reason: collision with root package name */
    public String f2995b;

    /* renamed from: c  reason: collision with root package name */
    public String f2996c;

    /* renamed from: d  reason: collision with root package name */
    public String f2997d;

    /* renamed from: e  reason: collision with root package name */
    public String f2998e;

    /* renamed from: f  reason: collision with root package name */
    public String f2999f;

    /* renamed from: g  reason: collision with root package name */
    public String f3000g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3001h;
    public String i;
    public boolean j;
    public boolean k;

    public i() {
        this.f2994a = "";
        this.f2995b = "";
        this.f2996c = "";
        this.f2997d = "";
        this.f2998e = "";
        this.f2999f = "";
        this.f3000g = "";
        this.f3001h = false;
        this.i = "";
        this.j = true;
    }

    public i(Intent intent) {
        this.f2994a = "";
        this.f2995b = "";
        this.f2996c = "";
        this.f2997d = "";
        this.f2998e = "";
        this.f2999f = "";
        this.f3000g = "";
        this.f3001h = false;
        this.i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f2997d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f2997d)) {
            this.f2997d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f2996c = intent.getStringExtra("access_token");
        this.f3000g = intent.getStringExtra("secret_key");
        this.f2994a = intent.getStringExtra("method");
        this.f2995b = intent.getStringExtra("method_type");
        this.f2998e = intent.getStringExtra("appid");
        this.f3001h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        return "method=" + this.f2994a + ", accessToken=" + this.f2996c + ", packageName=" + this.f2997d + ", appId=" + this.f2998e + ", userId=" + this.f2999f;
    }
}
