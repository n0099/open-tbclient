package com.baidu.live.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class a {
    private final PointF Gs;
    private final PointF Gt;
    private final PointF Gu;

    public a() {
        this.Gs = new PointF();
        this.Gt = new PointF();
        this.Gu = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.Gs = pointF;
        this.Gt = pointF2;
        this.Gu = pointF3;
    }

    public void f(float f, float f2) {
        this.Gs.set(f, f2);
    }

    public PointF iS() {
        return this.Gs;
    }

    public void g(float f, float f2) {
        this.Gt.set(f, f2);
    }

    public PointF iT() {
        return this.Gt;
    }

    public void h(float f, float f2) {
        this.Gu.set(f, f2);
    }

    public PointF iU() {
        return this.Gu;
    }
}
