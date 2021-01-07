package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3220a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3221b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null || !externalFilesDir.exists()) {
                this.f3221b = context.getFilesDir().getPath();
            } else {
                this.f3221b = externalFilesDir.getPath();
            }
        } else {
            this.f3221b = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        this.f3220a = false;
        this.c = this.f3221b + File.separator + "BaiduMapSDKNew";
        this.d = context.getCacheDir().getAbsolutePath();
        this.e = "";
        this.f = "";
    }

    public String a() {
        return this.f3221b;
    }

    public String b() {
        return this.f3221b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !f.class.isInstance(obj)) {
            return false;
        }
        return this.f3221b.equals(((f) obj).f3221b);
    }
}
