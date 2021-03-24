package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f7873a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7874b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7875c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7876d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7877e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7878f;

    public d(Context context) {
        this.f7873a = false;
        this.f7874b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f7875c = this.f7874b + File.separator + "BaiduMapSDKNew";
        this.f7876d = context.getCacheDir().getAbsolutePath();
        this.f7877e = "";
        this.f7878f = "";
    }

    public d(String str, boolean z, String str2, Context context) {
        this.f7873a = z;
        this.f7874b = str;
        this.f7875c = this.f7874b + File.separator + "BaiduMapSDKNew";
        this.f7876d = this.f7875c + File.separator + SapiOptions.q;
        this.f7877e = context.getCacheDir().getAbsolutePath();
        this.f7878f = str2;
    }

    public String a() {
        return this.f7874b;
    }

    public String b() {
        return this.f7874b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.f7876d;
    }

    public String d() {
        return this.f7877e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !d.class.isInstance(obj)) {
            return false;
        }
        return this.f7874b.equals(((d) obj).f7874b);
    }
}
