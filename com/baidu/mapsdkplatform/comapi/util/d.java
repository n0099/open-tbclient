package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f7909a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7910b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7911c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7912d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7913e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7914f;

    public d(Context context) {
        this.f7909a = false;
        this.f7910b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f7911c = this.f7910b + File.separator + "BaiduMapSDKNew";
        this.f7912d = context.getCacheDir().getAbsolutePath();
        this.f7913e = "";
        this.f7914f = "";
    }

    public d(String str, boolean z, String str2, Context context) {
        this.f7909a = z;
        this.f7910b = str;
        this.f7911c = this.f7910b + File.separator + "BaiduMapSDKNew";
        this.f7912d = this.f7911c + File.separator + SapiOptions.q;
        this.f7913e = context.getCacheDir().getAbsolutePath();
        this.f7914f = str2;
    }

    public String a() {
        return this.f7910b;
    }

    public String b() {
        return this.f7910b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.f7912d;
    }

    public String d() {
        return this.f7913e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !d.class.isInstance(obj)) {
            return false;
        }
        return this.f7910b.equals(((d) obj).f7910b);
    }
}
