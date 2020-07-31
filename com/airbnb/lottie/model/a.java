package com.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes20.dex */
public class a {
    private final PointF Dw;
    private final PointF Dx;
    private final PointF Dy;

    public a() {
        this.Dw = new PointF();
        this.Dx = new PointF();
        this.Dy = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.Dw = pointF;
        this.Dx = pointF2;
        this.Dy = pointF3;
    }

    public void f(float f, float f2) {
        this.Dw.set(f, f2);
    }

    public PointF hR() {
        return this.Dw;
    }

    public void g(float f, float f2) {
        this.Dx.set(f, f2);
    }

    public PointF hS() {
        return this.Dx;
    }

    public void h(float f, float f2) {
        this.Dy.set(f, f2);
    }

    public PointF hT() {
        return this.Dy;
    }
}
