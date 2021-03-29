package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f2959a;

    /* renamed from: b  reason: collision with root package name */
    public String f2960b;

    /* renamed from: c  reason: collision with root package name */
    public String f2961c;

    /* renamed from: d  reason: collision with root package name */
    public String f2962d;

    /* renamed from: e  reason: collision with root package name */
    public String f2963e;

    /* renamed from: f  reason: collision with root package name */
    public String f2964f;

    /* renamed from: g  reason: collision with root package name */
    public String f2965g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2966h;
    public String i;
    public boolean j;
    public boolean k;

    public i() {
        this.f2959a = "";
        this.f2960b = "";
        this.f2961c = "";
        this.f2962d = "";
        this.f2963e = "";
        this.f2964f = "";
        this.f2965g = "";
        this.f2966h = false;
        this.i = "";
        this.j = true;
    }

    public i(Intent intent) {
        this.f2959a = "";
        this.f2960b = "";
        this.f2961c = "";
        this.f2962d = "";
        this.f2963e = "";
        this.f2964f = "";
        this.f2965g = "";
        this.f2966h = false;
        this.i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f2962d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f2962d)) {
            this.f2962d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f2961c = intent.getStringExtra("access_token");
        this.f2965g = intent.getStringExtra("secret_key");
        this.f2959a = intent.getStringExtra("method");
        this.f2960b = intent.getStringExtra("method_type");
        this.f2963e = intent.getStringExtra("appid");
        this.f2966h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        return "method=" + this.f2959a + ", accessToken=" + this.f2961c + ", packageName=" + this.f2962d + ", appId=" + this.f2963e + ", userId=" + this.f2964f;
    }
}
