package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f3007a;

    /* renamed from: b  reason: collision with root package name */
    public String f3008b;

    /* renamed from: c  reason: collision with root package name */
    public String f3009c;

    /* renamed from: d  reason: collision with root package name */
    public String f3010d;

    /* renamed from: e  reason: collision with root package name */
    public String f3011e;

    /* renamed from: f  reason: collision with root package name */
    public String f3012f;

    /* renamed from: g  reason: collision with root package name */
    public String f3013g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3014h;

    /* renamed from: i  reason: collision with root package name */
    public String f3015i;
    public boolean j;
    public boolean k;

    public i() {
        this.f3007a = "";
        this.f3008b = "";
        this.f3009c = "";
        this.f3010d = "";
        this.f3011e = "";
        this.f3012f = "";
        this.f3013g = "";
        this.f3014h = false;
        this.f3015i = "";
        this.j = true;
    }

    public i(Intent intent) {
        this.f3007a = "";
        this.f3008b = "";
        this.f3009c = "";
        this.f3010d = "";
        this.f3011e = "";
        this.f3012f = "";
        this.f3013g = "";
        this.f3014h = false;
        this.f3015i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f3010d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f3010d)) {
            this.f3010d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f3009c = intent.getStringExtra("access_token");
        this.f3013g = intent.getStringExtra("secret_key");
        this.f3007a = intent.getStringExtra("method");
        this.f3008b = intent.getStringExtra("method_type");
        this.f3011e = intent.getStringExtra("appid");
        this.f3014h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f3015i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        return "method=" + this.f3007a + ", accessToken=" + this.f3009c + ", packageName=" + this.f3010d + ", appId=" + this.f3011e + ", userId=" + this.f3012f;
    }
}
