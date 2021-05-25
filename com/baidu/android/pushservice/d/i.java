package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f3011a;

    /* renamed from: b  reason: collision with root package name */
    public String f3012b;

    /* renamed from: c  reason: collision with root package name */
    public String f3013c;

    /* renamed from: d  reason: collision with root package name */
    public String f3014d;

    /* renamed from: e  reason: collision with root package name */
    public String f3015e;

    /* renamed from: f  reason: collision with root package name */
    public String f3016f;

    /* renamed from: g  reason: collision with root package name */
    public String f3017g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3018h;

    /* renamed from: i  reason: collision with root package name */
    public String f3019i;
    public boolean j;
    public boolean k;

    public i() {
        this.f3011a = "";
        this.f3012b = "";
        this.f3013c = "";
        this.f3014d = "";
        this.f3015e = "";
        this.f3016f = "";
        this.f3017g = "";
        this.f3018h = false;
        this.f3019i = "";
        this.j = true;
    }

    public i(Intent intent) {
        this.f3011a = "";
        this.f3012b = "";
        this.f3013c = "";
        this.f3014d = "";
        this.f3015e = "";
        this.f3016f = "";
        this.f3017g = "";
        this.f3018h = false;
        this.f3019i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f3014d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f3014d)) {
            this.f3014d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f3013c = intent.getStringExtra("access_token");
        this.f3017g = intent.getStringExtra("secret_key");
        this.f3011a = intent.getStringExtra("method");
        this.f3012b = intent.getStringExtra("method_type");
        this.f3015e = intent.getStringExtra("appid");
        this.f3018h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f3019i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        return "method=" + this.f3011a + ", accessToken=" + this.f3013c + ", packageName=" + this.f3014d + ", appId=" + this.f3015e + ", userId=" + this.f3016f;
    }
}
