package com.baidu.platform.comapi.wnplatform.o.b.a;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
/* loaded from: classes8.dex */
public class a {
    private int a = -1;
    private int b = -1;
    private float c = -1.0f;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private double g = -1.0d;

    public void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.a = displayMetrics.widthPixels;
        this.b = displayMetrics.heightPixels;
        this.c = displayMetrics.density;
        this.d = (int) displayMetrics.xdpi;
        this.e = (int) displayMetrics.ydpi;
        if (Build.VERSION.SDK_INT > 3) {
            double sqrt = Math.sqrt((displayMetrics.heightPixels * displayMetrics.heightPixels) + (displayMetrics.widthPixels * displayMetrics.widthPixels));
            double d = displayMetrics.widthPixels / displayMetrics.xdpi;
            double d2 = displayMetrics.heightPixels / displayMetrics.ydpi;
            this.f = (int) Math.ceil(sqrt / Math.sqrt((d * d) + (d2 * d2)));
            if (this.f < 240) {
                this.f = displayMetrics.densityDpi;
            }
        } else {
            this.f = 160;
        }
        if (this.f == 0) {
            this.f = 160;
        }
        this.g = this.f / 240.0d;
    }

    public int a() {
        if (this.a == -1) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.a;
    }

    public int b() {
        if (this.b == -1) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.b;
    }

    public float c() {
        if (this.c == -1.0f) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.c;
    }
}
