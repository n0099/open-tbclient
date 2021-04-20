package com.baidu.platform.comapi.wnplatform.o.b.a;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f9902a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f9903b = -1;

    /* renamed from: c  reason: collision with root package name */
    public float f9904c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public int f9905d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f9906e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f9907f = -1;

    /* renamed from: g  reason: collision with root package name */
    public double f9908g = -1.0d;

    public void a(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f9902a = displayMetrics.widthPixels;
        this.f9903b = displayMetrics.heightPixels;
        this.f9904c = displayMetrics.density;
        this.f9905d = (int) displayMetrics.xdpi;
        this.f9906e = (int) displayMetrics.ydpi;
        if (Build.VERSION.SDK_INT > 3) {
            double sqrt = Math.sqrt((i2 * i2) + (i * i));
            double d2 = displayMetrics.widthPixels / displayMetrics.xdpi;
            double d3 = displayMetrics.heightPixels / displayMetrics.ydpi;
            int ceil = (int) Math.ceil(sqrt / Math.sqrt((d2 * d2) + (d3 * d3)));
            this.f9907f = ceil;
            if (ceil < 240) {
                this.f9907f = displayMetrics.densityDpi;
            }
        } else {
            this.f9907f = 160;
        }
        if (this.f9907f == 0) {
            this.f9907f = 160;
        }
        this.f9908g = this.f9907f / 240.0d;
    }

    public int b() {
        if (this.f9903b == -1) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.f9903b;
    }

    public float c() {
        if (this.f9904c == -1.0f) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.f9904c;
    }

    public int a() {
        if (this.f9902a == -1) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.f9902a;
    }
}
