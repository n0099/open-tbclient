package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes5.dex */
public class i implements m<PointF, PointF> {
    private final b hE;
    private final b hF;

    public i(b bVar, b bVar2) {
        this.hE = bVar;
        this.hF = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> cm() {
        return new com.airbnb.lottie.a.b.m(this.hE.cm(), this.hF.cm());
    }
}
