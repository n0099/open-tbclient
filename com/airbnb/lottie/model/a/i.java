package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes3.dex */
public class i implements m<PointF, PointF> {
    private final b Fp;
    private final b Fq;

    public i(b bVar, b bVar2) {
        this.Fp = bVar;
        this.Fq = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> jc() {
        return new com.airbnb.lottie.a.b.m(this.Fp.jc(), this.Fq.jc());
    }
}
