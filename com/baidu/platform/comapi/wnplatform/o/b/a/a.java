package com.baidu.platform.comapi.wnplatform.o.b.a;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f10343a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f10344b = -1;

    /* renamed from: c  reason: collision with root package name */
    public float f10345c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public int f10346d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f10347e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f10348f = -1;

    /* renamed from: g  reason: collision with root package name */
    public double f10349g = -1.0d;

    public void a(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f10343a = displayMetrics.widthPixels;
        this.f10344b = displayMetrics.heightPixels;
        this.f10345c = displayMetrics.density;
        this.f10346d = (int) displayMetrics.xdpi;
        this.f10347e = (int) displayMetrics.ydpi;
        if (Build.VERSION.SDK_INT > 3) {
            double sqrt = Math.sqrt((i2 * i2) + (i * i));
            double d2 = displayMetrics.widthPixels / displayMetrics.xdpi;
            double d3 = displayMetrics.heightPixels / displayMetrics.ydpi;
            Double.isNaN(d2);
            Double.isNaN(d2);
            Double.isNaN(d3);
            Double.isNaN(d3);
            int ceil = (int) Math.ceil(sqrt / Math.sqrt((d2 * d2) + (d3 * d3)));
            this.f10348f = ceil;
            if (ceil < 240) {
                this.f10348f = displayMetrics.densityDpi;
            }
        } else {
            this.f10348f = 160;
        }
        if (this.f10348f == 0) {
            this.f10348f = 160;
        }
        double d4 = this.f10348f;
        Double.isNaN(d4);
        this.f10349g = d4 / 240.0d;
    }

    public int b() {
        if (this.f10344b == -1) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.f10344b;
    }

    public float c() {
        if (this.f10345c == -1.0f) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.f10345c;
    }

    public int a() {
        if (this.f10343a == -1) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.f10343a;
    }
}
