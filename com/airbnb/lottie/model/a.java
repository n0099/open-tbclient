package com.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes18.dex */
public class a {
    private final PointF Ee;
    private final PointF Ef;
    private final PointF Eg;

    public a() {
        this.Ee = new PointF();
        this.Ef = new PointF();
        this.Eg = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.Ee = pointF;
        this.Ef = pointF2;
        this.Eg = pointF3;
    }

    public void e(float f, float f2) {
        this.Ee.set(f, f2);
    }

    public PointF js() {
        return this.Ee;
    }

    public void f(float f, float f2) {
        this.Ef.set(f, f2);
    }

    public PointF jt() {
        return this.Ef;
    }

    public void g(float f, float f2) {
        this.Eg.set(f, f2);
    }

    public PointF ju() {
        return this.Eg;
    }
}
