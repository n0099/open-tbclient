package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8195a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8196b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8197c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8198d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8199e;

    /* renamed from: f  reason: collision with root package name */
    public final String f8200f;

    public d(Context context) {
        this.f8195a = false;
        this.f8196b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f8197c = this.f8196b + File.separator + "BaiduMapSDKNew";
        this.f8198d = context.getCacheDir().getAbsolutePath();
        this.f8199e = "";
        this.f8200f = "";
    }

    public d(String str, boolean z, String str2, Context context) {
        this.f8195a = z;
        this.f8196b = str;
        this.f8197c = this.f8196b + File.separator + "BaiduMapSDKNew";
        this.f8198d = this.f8197c + File.separator + SapiOptions.KEY_CACHE;
        this.f8199e = context.getCacheDir().getAbsolutePath();
        this.f8200f = str2;
    }

    public String a() {
        return this.f8196b;
    }

    public String b() {
        return this.f8196b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.f8198d;
    }

    public String d() {
        return this.f8199e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !d.class.isInstance(obj)) {
            return false;
        }
        return this.f8196b.equals(((d) obj).f8196b);
    }
}
