package com.baidu.pano.platform.c;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private float[] f3904a = {0.0f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    private long f3905b = -1;
    private long c = 250;
    private Interpolator d = new DecelerateInterpolator();
    private EnumC0272a e = EnumC0272a.None;

    /* renamed from: com.baidu.pano.platform.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public enum EnumC0272a {
        None,
        Running
    }

    public float a() {
        float f = 0.0f;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f3905b == -1) {
            this.f3905b = currentTimeMillis;
        }
        float f2 = (((float) (currentTimeMillis - this.f3905b)) * 1.0f) / ((float) this.c);
        if (f2 < 0.0f) {
            this.e = EnumC0272a.None;
        } else if (f2 > 1.0f) {
            this.e = EnumC0272a.None;
            f = 1.0f;
        } else {
            f = this.d.getInterpolation(f2);
            this.e = EnumC0272a.Running;
        }
        return (f * this.f3904a[1]) + this.f3904a[0];
    }

    public void a(float f, float f2) {
        this.f3904a[0] = f;
        this.f3904a[1] = f2 - f;
        this.f3905b = -1L;
        this.e = EnumC0272a.Running;
    }
}
