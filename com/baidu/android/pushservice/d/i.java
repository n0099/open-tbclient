package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f3030a;

    /* renamed from: b  reason: collision with root package name */
    public String f3031b;

    /* renamed from: c  reason: collision with root package name */
    public String f3032c;

    /* renamed from: d  reason: collision with root package name */
    public String f3033d;

    /* renamed from: e  reason: collision with root package name */
    public String f3034e;

    /* renamed from: f  reason: collision with root package name */
    public String f3035f;

    /* renamed from: g  reason: collision with root package name */
    public String f3036g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3037h;

    /* renamed from: i  reason: collision with root package name */
    public String f3038i;
    public boolean j;
    public boolean k;

    public i() {
        this.f3030a = "";
        this.f3031b = "";
        this.f3032c = "";
        this.f3033d = "";
        this.f3034e = "";
        this.f3035f = "";
        this.f3036g = "";
        this.f3037h = false;
        this.f3038i = "";
        this.j = true;
    }

    public i(Intent intent) {
        this.f3030a = "";
        this.f3031b = "";
        this.f3032c = "";
        this.f3033d = "";
        this.f3034e = "";
        this.f3035f = "";
        this.f3036g = "";
        this.f3037h = false;
        this.f3038i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f3033d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f3033d)) {
            this.f3033d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f3032c = intent.getStringExtra("access_token");
        this.f3036g = intent.getStringExtra("secret_key");
        this.f3030a = intent.getStringExtra("method");
        this.f3031b = intent.getStringExtra("method_type");
        this.f3034e = intent.getStringExtra("appid");
        this.f3037h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f3038i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        return "method=" + this.f3030a + ", accessToken=" + this.f3032c + ", packageName=" + this.f3033d + ", appId=" + this.f3034e + ", userId=" + this.f3035f;
    }
}
