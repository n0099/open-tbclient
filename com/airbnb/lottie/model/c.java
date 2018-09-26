package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF pA;
    private final PointF py;
    private final PointF pz;

    public c() {
        this.py = new PointF();
        this.pz = new PointF();
        this.pA = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.py = pointF;
        this.pz = pointF2;
        this.pA = pointF3;
    }

    public void c(float f, float f2) {
        this.py.set(f, f2);
    }

    public PointF dk() {
        return this.py;
    }

    public void d(float f, float f2) {
        this.pz.set(f, f2);
    }

    public PointF dl() {
        return this.pz;
    }

    public void e(float f, float f2) {
        this.pA.set(f, f2);
    }

    public PointF dm() {
        return this.pA;
    }
}
