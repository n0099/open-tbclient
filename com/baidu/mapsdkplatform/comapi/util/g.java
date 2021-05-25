package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f7907a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7908b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7909c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7910d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7911e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7912f;

    public g(Context context) {
        this.f7907a = false;
        this.f7908b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f7909c = this.f7908b + File.separator + "BaiduMapSDKNew";
        this.f7910d = context.getCacheDir().getAbsolutePath();
        this.f7911e = "";
        this.f7912f = "";
    }

    public g(String str, boolean z, String str2, Context context) {
        this.f7907a = z;
        this.f7908b = str;
        this.f7909c = this.f7908b + File.separator + "BaiduMapSDKNew";
        this.f7910d = this.f7909c + File.separator + SapiOptions.KEY_CACHE;
        this.f7911e = context.getCacheDir().getAbsolutePath();
        this.f7912f = str2;
    }

    public String a() {
        return this.f7908b;
    }

    public String b() {
        return this.f7908b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.f7910d;
    }

    public String d() {
        return this.f7911e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !g.class.isInstance(obj)) {
            return false;
        }
        return this.f7908b.equals(((g) obj).f7908b);
    }
}
