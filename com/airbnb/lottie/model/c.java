package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF mT;
    private final PointF mU;
    private final PointF mV;

    public c() {
        this.mT = new PointF();
        this.mU = new PointF();
        this.mV = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.mT = pointF;
        this.mU = pointF2;
        this.mV = pointF3;
    }

    public void c(float f, float f2) {
        this.mT.set(f, f2);
    }

    public PointF cd() {
        return this.mT;
    }

    public void d(float f, float f2) {
        this.mU.set(f, f2);
    }

    public PointF ce() {
        return this.mU;
    }

    public void e(float f, float f2) {
        this.mV.set(f, f2);
    }

    public PointF cf() {
        return this.mV;
    }
}
