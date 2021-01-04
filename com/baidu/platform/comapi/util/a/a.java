package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.vi.VIContext;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f4380a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f4381b = -1;
    private float c = -1.0f;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private double g = -1.0d;

    public int a() {
        if (this.f4380a == -1) {
            a(VIContext.getContext());
        }
        return this.f4380a;
    }

    public void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f4380a = displayMetrics.widthPixels;
        this.f4381b = displayMetrics.heightPixels;
        this.c = displayMetrics.density;
        this.d = (int) displayMetrics.xdpi;
        this.e = (int) displayMetrics.ydpi;
        if (Build.VERSION.SDK_INT > 3) {
            this.f = displayMetrics.densityDpi;
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

    public int b() {
        if (this.f4381b == -1) {
            a(VIContext.getContext());
        }
        return this.f4381b;
    }

    public float c() {
        if (this.c == -1.0f) {
            a(VIContext.getContext());
        }
        return this.c;
    }

    public int d() {
        if (this.f == -1) {
            a(VIContext.getContext());
        }
        return this.f;
    }
}
