package com.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF nF;
    private final PointF nG;
    private final PointF nH;

    public c() {
        this.nF = new PointF();
        this.nG = new PointF();
        this.nH = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.nF = pointF;
        this.nG = pointF2;
        this.nH = pointF3;
    }

    public void f(float f, float f2) {
        this.nF.set(f, f2);
    }

    public PointF cz() {
        return this.nF;
    }

    public void g(float f, float f2) {
        this.nG.set(f, f2);
    }

    public PointF cA() {
        return this.nG;
    }

    public void h(float f, float f2) {
        this.nH.set(f, f2);
    }

    public PointF cB() {
        return this.nH;
    }
}
