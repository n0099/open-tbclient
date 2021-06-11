package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f7950a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7951b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7952c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7953d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7954e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7955f;

    public g(Context context) {
        this.f7950a = false;
        this.f7951b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f7952c = this.f7951b + File.separator + "BaiduMapSDKNew";
        this.f7953d = context.getCacheDir().getAbsolutePath();
        this.f7954e = "";
        this.f7955f = "";
    }

    public g(String str, boolean z, String str2, Context context) {
        this.f7950a = z;
        this.f7951b = str;
        this.f7952c = this.f7951b + File.separator + "BaiduMapSDKNew";
        this.f7953d = this.f7952c + File.separator + SapiOptions.KEY_CACHE;
        this.f7954e = context.getCacheDir().getAbsolutePath();
        this.f7955f = str2;
    }

    public String a() {
        return this.f7951b;
    }

    public String b() {
        return this.f7951b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.f7953d;
    }

    public String d() {
        return this.f7954e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !g.class.isInstance(obj)) {
            return false;
        }
        return this.f7951b.equals(((g) obj).f7951b);
    }
}
