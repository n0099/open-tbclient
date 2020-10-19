package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.vi.VIContext;
import java.io.File;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f2942a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public String a() {
        if (TextUtils.isEmpty(this.f2942a)) {
            a(VIContext.getContext());
        }
        return this.f2942a;
    }

    public void a(Context context) {
        this.f2942a = context.getFilesDir().getAbsolutePath();
        this.d = context.getCacheDir().getAbsolutePath();
        this.e = this.d;
        this.b = Environment.getExternalStorageDirectory().getPath();
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
        if (TextUtils.isEmpty(this.b)) {
            a(VIContext.getContext());
        }
        return this.b;
    }

    public String c() {
        if (TextUtils.isEmpty(this.d)) {
            a(VIContext.getContext());
        }
        return this.d;
    }
}
