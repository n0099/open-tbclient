package com.baidu.platform.comapi.wnplatform.o.b.a;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f10270a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f10271b = -1;

    /* renamed from: c  reason: collision with root package name */
    public float f10272c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public int f10273d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f10274e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f10275f = -1;

    /* renamed from: g  reason: collision with root package name */
    public double f10276g = -1.0d;

    public void a(Context context) {
        int i2;
        int i3;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f10270a = displayMetrics.widthPixels;
        this.f10271b = displayMetrics.heightPixels;
        this.f10272c = displayMetrics.density;
        this.f10273d = (int) displayMetrics.xdpi;
        this.f10274e = (int) displayMetrics.ydpi;
        if (Build.VERSION.SDK_INT > 3) {
            double sqrt = Math.sqrt((i3 * i3) + (i2 * i2));
            double d2 = displayMetrics.widthPixels / displayMetrics.xdpi;
            double d3 = displayMetrics.heightPixels / displayMetrics.ydpi;
            int ceil = (int) Math.ceil(sqrt / Math.sqrt((d2 * d2) + (d3 * d3)));
            this.f10275f = ceil;
            if (ceil < 240) {
                this.f10275f = displayMetrics.densityDpi;
            }
        } else {
            this.f10275f = 160;
        }
        if (this.f10275f == 0) {
            this.f10275f = 160;
        }
        this.f10276g = this.f10275f / 240.0d;
    }

    public int b() {
        if (this.f10271b == -1) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.f10271b;
    }

    public float c() {
        if (this.f10272c == -1.0f) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.f10272c;
    }

    public int a() {
        if (this.f10270a == -1) {
            a(com.baidu.platform.comapi.wnplatform.o.b.a.a());
        }
        return this.f10270a;
    }
}
