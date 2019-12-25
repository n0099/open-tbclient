package com.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes4.dex */
public class a {
    private final PointF hl;
    private final PointF hm;
    private final PointF hn;

    public a() {
        this.hl = new PointF();
        this.hm = new PointF();
        this.hn = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.hl = pointF;
        this.hm = pointF2;
        this.hn = pointF3;
    }

    public void f(float f, float f2) {
        this.hl.set(f, f2);
    }

    public PointF cd() {
        return this.hl;
    }

    public void g(float f, float f2) {
        this.hm.set(f, f2);
    }

    public PointF ce() {
        return this.hm;
    }

    public void h(float f, float f2) {
        this.hn.set(f, f2);
    }

    public PointF cf() {
        return this.hn;
    }
}
