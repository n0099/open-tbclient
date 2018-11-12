package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF qm;
    private final PointF qn;
    private final PointF qo;

    public c() {
        this.qm = new PointF();
        this.qn = new PointF();
        this.qo = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.qm = pointF;
        this.qn = pointF2;
        this.qo = pointF3;
    }

    public void f(float f, float f2) {
        this.qm.set(f, f2);
    }

    public PointF dB() {
        return this.qm;
    }

    public void g(float f, float f2) {
        this.qn.set(f, f2);
    }

    public PointF dC() {
        return this.qn;
    }

    public void h(float f, float f2) {
        this.qo.set(f, f2);
    }

    public PointF dD() {
        return this.qo;
    }
}
