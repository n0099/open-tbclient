package com.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes16.dex */
public class a {
    private final PointF Ev;
    private final PointF Ew;
    private final PointF Ex;

    public a() {
        this.Ev = new PointF();
        this.Ew = new PointF();
        this.Ex = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.Ev = pointF;
        this.Ew = pointF2;
        this.Ex = pointF3;
    }

    public void e(float f, float f2) {
        this.Ev.set(f, f2);
    }

    public PointF ju() {
        return this.Ev;
    }

    public void f(float f, float f2) {
        this.Ew.set(f, f2);
    }

    public PointF jv() {
        return this.Ew;
    }

    public void g(float f, float f2) {
        this.Ex.set(f, f2);
    }

    public PointF jw() {
        return this.Ex;
    }
}
