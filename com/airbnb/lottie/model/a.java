package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class a {
    private final PointF Fb;
    private final PointF Fc;
    private final PointF Fd;

    public a() {
        this.Fb = new PointF();
        this.Fc = new PointF();
        this.Fd = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.Fb = pointF;
        this.Fc = pointF2;
        this.Fd = pointF3;
    }

    public void e(float f, float f2) {
        this.Fb.set(f, f2);
    }

    public PointF iT() {
        return this.Fb;
    }

    public void f(float f, float f2) {
        this.Fc.set(f, f2);
    }

    public PointF iU() {
        return this.Fc;
    }

    public void g(float f, float f2) {
        this.Fd.set(f, f2);
    }

    public PointF iV() {
        return this.Fd;
    }
}
