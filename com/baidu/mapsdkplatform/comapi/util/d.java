package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3162a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3163b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.f3162a = false;
        this.f3163b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.c = this.f3163b + File.separator + "BaiduMapSDKNew";
        this.d = context.getCacheDir().getAbsolutePath();
        this.e = "";
        this.f = "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, boolean z, String str2, Context context) {
        this.f3162a = z;
        this.f3163b = str;
        this.c = this.f3163b + File.separator + "BaiduMapSDKNew";
        this.d = this.c + File.separator + "cache";
        this.e = context.getCacheDir().getAbsolutePath();
        this.f = str2;
    }

    public String a() {
        return this.f3163b;
    }

    public String b() {
        return this.f3163b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !d.class.isInstance(obj)) {
            return false;
        }
        return this.f3163b.equals(((d) obj).f3163b);
    }
}
