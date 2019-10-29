package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF gb;
    private final PointF gc;
    private final PointF gd;

    public c() {
        this.gb = new PointF();
        this.gc = new PointF();
        this.gd = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.gb = pointF;
        this.gc = pointF2;
        this.gd = pointF3;
    }

    public void f(float f, float f2) {
        this.gb.set(f, f2);
    }

    public PointF bS() {
        return this.gb;
    }

    public void g(float f, float f2) {
        this.gc.set(f, f2);
    }

    public PointF bT() {
        return this.gc;
    }

    public void h(float f, float f2) {
        this.gd.set(f, f2);
    }

    public PointF bU() {
        return this.gd;
    }
}
