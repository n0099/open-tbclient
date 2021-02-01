package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes4.dex */
public class a {
    private final PointF EZ;
    private final PointF Fa;
    private final PointF Fb;

    public a() {
        this.EZ = new PointF();
        this.Fa = new PointF();
        this.Fb = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.EZ = pointF;
        this.Fa = pointF2;
        this.Fb = pointF3;
    }

    public void f(float f, float f2) {
        this.EZ.set(f, f2);
    }

    public PointF iS() {
        return this.EZ;
    }

    public void g(float f, float f2) {
        this.Fa.set(f, f2);
    }

    public PointF iT() {
        return this.Fa;
    }

    public void h(float f, float f2) {
        this.Fb.set(f, f2);
    }

    public PointF iU() {
        return this.Fb;
    }
}
