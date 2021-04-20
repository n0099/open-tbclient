package com.baidu.pano.platform.c;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public float[] f8981a = {0.0f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    public long f8982b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f8983c = 250;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f8984d = new DecelerateInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public EnumC0114a f8985e = EnumC0114a.None;

    /* renamed from: com.baidu.pano.platform.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0114a {
        None,
        Running
    }

    public float a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f8982b == -1) {
            this.f8982b = currentTimeMillis;
        }
        float f2 = 1.0f;
        float f3 = (((float) (currentTimeMillis - this.f8982b)) * 1.0f) / ((float) this.f8983c);
        if (f3 < 0.0f) {
            this.f8985e = EnumC0114a.None;
            f2 = 0.0f;
        } else if (f3 > 1.0f) {
            this.f8985e = EnumC0114a.None;
        } else {
            f2 = this.f8984d.getInterpolation(f3);
            this.f8985e = EnumC0114a.Running;
        }
        float[] fArr = this.f8981a;
        return fArr[0] + (f2 * fArr[1]);
    }

    public void a(float f2, float f3) {
        float[] fArr = this.f8981a;
        fArr[0] = f2;
        fArr[1] = f3 - f2;
        this.f8982b = -1L;
        this.f8985e = EnumC0114a.Running;
    }
}
