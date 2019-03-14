package com.baidu.pano.platform.c;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
/* loaded from: classes5.dex */
public class a {
    private float[] a = {0.0f, 0.0f};
    private long b = -1;
    private long c = 250;
    private Interpolator d = new DecelerateInterpolator();
    private EnumC0063a e = EnumC0063a.None;

    /* renamed from: com.baidu.pano.platform.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public enum EnumC0063a {
        None,
        Running
    }

    public float a() {
        float f = 0.0f;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.b == -1) {
            this.b = currentTimeMillis;
        }
        float f2 = (((float) (currentTimeMillis - this.b)) * 1.0f) / ((float) this.c);
        if (f2 < 0.0f) {
            this.e = EnumC0063a.None;
        } else if (f2 > 1.0f) {
            this.e = EnumC0063a.None;
            f = 1.0f;
        } else {
            f = this.d.getInterpolation(f2);
            this.e = EnumC0063a.Running;
        }
        return (f * this.a[1]) + this.a[0];
    }

    public void a(float f, float f2) {
        this.a[0] = f;
        this.a[1] = f2 - f;
        this.b = -1L;
        this.e = EnumC0063a.Running;
    }
}
