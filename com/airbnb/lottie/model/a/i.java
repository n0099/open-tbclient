package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b Ev;
    private final b Ew;

    public i(b bVar, b bVar2) {
        this.Ev = bVar;
        this.Ew = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> jC() {
        return new com.airbnb.lottie.a.b.m(this.Ev.jC(), this.Ew.jC());
    }
}
