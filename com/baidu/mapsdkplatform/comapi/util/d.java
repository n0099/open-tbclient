package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f7874a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7875b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7876c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7877d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7878e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7879f;

    public d(Context context) {
        this.f7874a = false;
        this.f7875b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f7876c = this.f7875b + File.separator + "BaiduMapSDKNew";
        this.f7877d = context.getCacheDir().getAbsolutePath();
        this.f7878e = "";
        this.f7879f = "";
    }

    public d(String str, boolean z, String str2, Context context) {
        this.f7874a = z;
        this.f7875b = str;
        this.f7876c = this.f7875b + File.separator + "BaiduMapSDKNew";
        this.f7877d = this.f7876c + File.separator + SapiOptions.q;
        this.f7878e = context.getCacheDir().getAbsolutePath();
        this.f7879f = str2;
    }

    public String a() {
        return this.f7875b;
    }

    public String b() {
        return this.f7875b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.f7877d;
    }

    public String d() {
        return this.f7878e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !d.class.isInstance(obj)) {
            return false;
        }
        return this.f7875b.equals(((d) obj).f7875b);
    }
}
