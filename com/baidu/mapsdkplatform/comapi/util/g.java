package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8007a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8008b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8009c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8010d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8011e;

    /* renamed from: f  reason: collision with root package name */
    public final String f8012f;

    public g(Context context) {
        this.f8007a = false;
        this.f8008b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f8009c = this.f8008b + File.separator + "BaiduMapSDKNew";
        this.f8010d = context.getCacheDir().getAbsolutePath();
        this.f8011e = "";
        this.f8012f = "";
    }

    public g(String str, boolean z, String str2, Context context) {
        this.f8007a = z;
        this.f8008b = str;
        this.f8009c = this.f8008b + File.separator + "BaiduMapSDKNew";
        this.f8010d = this.f8009c + File.separator + SapiOptions.KEY_CACHE;
        this.f8011e = context.getCacheDir().getAbsolutePath();
        this.f8012f = str2;
    }

    public String a() {
        return this.f8008b;
    }

    public String b() {
        return this.f8008b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.f8010d;
    }

    public String d() {
        return this.f8011e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !g.class.isInstance(obj)) {
            return false;
        }
        return this.f8008b.equals(((g) obj).f8008b);
    }
}
