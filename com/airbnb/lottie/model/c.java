package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF mU;
    private final PointF mV;
    private final PointF mW;

    public c() {
        this.mU = new PointF();
        this.mV = new PointF();
        this.mW = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.mU = pointF;
        this.mV = pointF2;
        this.mW = pointF3;
    }

    public void c(float f, float f2) {
        this.mU.set(f, f2);
    }

    public PointF cd() {
        return this.mU;
    }

    public void d(float f, float f2) {
        this.mV.set(f, f2);
    }

    public PointF ce() {
        return this.mV;
    }

    public void e(float f, float f2) {
        this.mW.set(f, f2);
    }

    public PointF cf() {
        return this.mW;
    }
}
