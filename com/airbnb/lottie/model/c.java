package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF ng;
    private final PointF nh;
    private final PointF ni;

    public c() {
        this.ng = new PointF();
        this.nh = new PointF();
        this.ni = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.ng = pointF;
        this.nh = pointF2;
        this.ni = pointF3;
    }

    public void c(float f, float f2) {
        this.ng.set(f, f2);
    }

    public PointF cf() {
        return this.ng;
    }

    public void d(float f, float f2) {
        this.nh.set(f, f2);
    }

    public PointF cg() {
        return this.nh;
    }

    public void e(float f, float f2) {
        this.ni.set(f, f2);
    }

    public PointF ch() {
        return this.ni;
    }
}
