package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF nf;
    private final PointF ng;
    private final PointF nh;

    public c() {
        this.nf = new PointF();
        this.ng = new PointF();
        this.nh = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.nf = pointF;
        this.ng = pointF2;
        this.nh = pointF3;
    }

    public void c(float f, float f2) {
        this.nf.set(f, f2);
    }

    public PointF cf() {
        return this.nf;
    }

    public void d(float f, float f2) {
        this.ng.set(f, f2);
    }

    public PointF cg() {
        return this.ng;
    }

    public void e(float f, float f2) {
        this.nh.set(f, f2);
    }

    public PointF ch() {
        return this.nh;
    }
}
