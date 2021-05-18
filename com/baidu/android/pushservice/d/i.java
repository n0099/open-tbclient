package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f3008a;

    /* renamed from: b  reason: collision with root package name */
    public String f3009b;

    /* renamed from: c  reason: collision with root package name */
    public String f3010c;

    /* renamed from: d  reason: collision with root package name */
    public String f3011d;

    /* renamed from: e  reason: collision with root package name */
    public String f3012e;

    /* renamed from: f  reason: collision with root package name */
    public String f3013f;

    /* renamed from: g  reason: collision with root package name */
    public String f3014g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3015h;

    /* renamed from: i  reason: collision with root package name */
    public String f3016i;
    public boolean j;
    public boolean k;

    public i() {
        this.f3008a = "";
        this.f3009b = "";
        this.f3010c = "";
        this.f3011d = "";
        this.f3012e = "";
        this.f3013f = "";
        this.f3014g = "";
        this.f3015h = false;
        this.f3016i = "";
        this.j = true;
    }

    public i(Intent intent) {
        this.f3008a = "";
        this.f3009b = "";
        this.f3010c = "";
        this.f3011d = "";
        this.f3012e = "";
        this.f3013f = "";
        this.f3014g = "";
        this.f3015h = false;
        this.f3016i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f3011d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f3011d)) {
            this.f3011d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f3010c = intent.getStringExtra("access_token");
        this.f3014g = intent.getStringExtra("secret_key");
        this.f3008a = intent.getStringExtra("method");
        this.f3009b = intent.getStringExtra("method_type");
        this.f3012e = intent.getStringExtra("appid");
        this.f3015h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f3016i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        return "method=" + this.f3008a + ", accessToken=" + this.f3010c + ", packageName=" + this.f3011d + ", appId=" + this.f3012e + ", userId=" + this.f3013f;
    }
}
