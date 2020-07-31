package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes20.dex */
public class i implements m<PointF, PointF> {
    private final b DR;
    private final b DS;

    public i(b bVar, b bVar2) {
        this.DR = bVar;
        this.DS = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> ia() {
        return new com.airbnb.lottie.a.b.m(this.DR.ia(), this.DS.ia());
    }
}
