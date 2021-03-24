package com.baidu.pano.platform.c;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float[] f9422a = {0.0f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    public long f9423b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f9424c = 250;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f9425d = new DecelerateInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public EnumC0114a f9426e = EnumC0114a.None;

    /* renamed from: com.baidu.pano.platform.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0114a {
        None,
        Running
    }

    public float a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f9423b == -1) {
            this.f9423b = currentTimeMillis;
        }
        float f2 = 1.0f;
        float f3 = (((float) (currentTimeMillis - this.f9423b)) * 1.0f) / ((float) this.f9424c);
        if (f3 < 0.0f) {
            this.f9426e = EnumC0114a.None;
            f2 = 0.0f;
        } else if (f3 > 1.0f) {
            this.f9426e = EnumC0114a.None;
        } else {
            f2 = this.f9425d.getInterpolation(f3);
            this.f9426e = EnumC0114a.Running;
        }
        float[] fArr = this.f9422a;
        return fArr[0] + (f2 * fArr[1]);
    }

    public void a(float f2, float f3) {
        float[] fArr = this.f9422a;
        fArr[0] = f2;
        fArr[1] = f3 - f2;
        this.f9423b = -1L;
        this.f9426e = EnumC0114a.Running;
    }
}
