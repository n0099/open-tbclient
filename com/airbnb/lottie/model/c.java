package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF qg;
    private final PointF qh;
    private final PointF qi;

    public c() {
        this.qg = new PointF();
        this.qh = new PointF();
        this.qi = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.qg = pointF;
        this.qh = pointF2;
        this.qi = pointF3;
    }

    public void f(float f, float f2) {
        this.qg.set(f, f2);
    }

    public PointF dA() {
        return this.qg;
    }

    public void g(float f, float f2) {
        this.qh.set(f, f2);
    }

    public PointF dB() {
        return this.qh;
    }

    public void h(float f, float f2) {
        this.qi.set(f, f2);
    }

    public PointF dC() {
        return this.qi;
    }
}
