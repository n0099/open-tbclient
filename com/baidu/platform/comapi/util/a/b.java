package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.vi.VIContext;
import java.io.File;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f4383a;

    /* renamed from: b  reason: collision with root package name */
    private String f4384b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public String a() {
        if (TextUtils.isEmpty(this.f4383a)) {
            a(VIContext.getContext());
        }
        return this.f4383a;
    }

    public void a(Context context) {
        this.f4383a = context.getFilesDir().getAbsolutePath();
        this.d = context.getCacheDir().getAbsolutePath();
        this.e = this.d;
        this.f4384b = Environment.getExternalStorageDirectory().getPath();
        this.c = Environment.getExternalStorageDirectory().getPath();
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            this.f = externalFilesDir.getAbsolutePath();
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            this.g = externalCacheDir.getAbsolutePath();
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f4384b)) {
            a(VIContext.getContext());
        }
        return this.f4384b;
    }

    public String c() {
        if (TextUtils.isEmpty(this.d)) {
            a(VIContext.getContext());
        }
        return this.d;
    }
}
