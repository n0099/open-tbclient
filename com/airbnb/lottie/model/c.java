package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF ql;
    private final PointF qm;
    private final PointF qn;

    public c() {
        this.ql = new PointF();
        this.qm = new PointF();
        this.qn = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.ql = pointF;
        this.qm = pointF2;
        this.qn = pointF3;
    }

    public void c(float f, float f2) {
        this.ql.set(f, f2);
    }

    public PointF dC() {
        return this.ql;
    }

    public void d(float f, float f2) {
        this.qm.set(f, f2);
    }

    public PointF dD() {
        return this.qm;
    }

    public void e(float f, float f2) {
        this.qn.set(f, f2);
    }

    public PointF dE() {
        return this.qn;
    }
}
