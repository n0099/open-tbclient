package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f2958a;

    /* renamed from: b  reason: collision with root package name */
    public String f2959b;

    /* renamed from: c  reason: collision with root package name */
    public String f2960c;

    /* renamed from: d  reason: collision with root package name */
    public String f2961d;

    /* renamed from: e  reason: collision with root package name */
    public String f2962e;

    /* renamed from: f  reason: collision with root package name */
    public String f2963f;

    /* renamed from: g  reason: collision with root package name */
    public String f2964g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2965h;
    public String i;
    public boolean j;
    public boolean k;

    public i() {
        this.f2958a = "";
        this.f2959b = "";
        this.f2960c = "";
        this.f2961d = "";
        this.f2962e = "";
        this.f2963f = "";
        this.f2964g = "";
        this.f2965h = false;
        this.i = "";
        this.j = true;
    }

    public i(Intent intent) {
        this.f2958a = "";
        this.f2959b = "";
        this.f2960c = "";
        this.f2961d = "";
        this.f2962e = "";
        this.f2963f = "";
        this.f2964g = "";
        this.f2965h = false;
        this.i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f2961d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f2961d)) {
            this.f2961d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f2960c = intent.getStringExtra("access_token");
        this.f2964g = intent.getStringExtra("secret_key");
        this.f2958a = intent.getStringExtra("method");
        this.f2959b = intent.getStringExtra("method_type");
        this.f2962e = intent.getStringExtra("appid");
        this.f2965h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        return "method=" + this.f2958a + ", accessToken=" + this.f2960c + ", packageName=" + this.f2961d + ", appId=" + this.f2962e + ", userId=" + this.f2963f;
    }
}
