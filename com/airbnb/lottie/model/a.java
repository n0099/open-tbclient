package com.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {
    private final PointF hp;
    private final PointF hq;
    private final PointF hr;

    public a() {
        this.hp = new PointF();
        this.hq = new PointF();
        this.hr = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.hp = pointF;
        this.hq = pointF2;
        this.hr = pointF3;
    }

    public void f(float f, float f2) {
        this.hp.set(f, f2);
    }

    public PointF ce() {
        return this.hp;
    }

    public void g(float f, float f2) {
        this.hq.set(f, f2);
    }

    public PointF cf() {
        return this.hq;
    }

    public void h(float f, float f2) {
        this.hr.set(f, f2);
    }

    public PointF cg() {
        return this.hr;
    }
}
