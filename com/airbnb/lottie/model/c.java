package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF nG;
    private final PointF nH;
    private final PointF nI;

    public c() {
        this.nG = new PointF();
        this.nH = new PointF();
        this.nI = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.nG = pointF;
        this.nH = pointF2;
        this.nI = pointF3;
    }

    public void f(float f, float f2) {
        this.nG.set(f, f2);
    }

    public PointF cu() {
        return this.nG;
    }

    public void g(float f, float f2) {
        this.nH.set(f, f2);
    }

    public PointF cv() {
        return this.nH;
    }

    public void h(float f, float f2) {
        this.nI.set(f, f2);
    }

    public PointF cw() {
        return this.nI;
    }
}
