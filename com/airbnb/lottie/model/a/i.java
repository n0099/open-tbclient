package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b Dk;
    private final b Dl;

    public i(b bVar, b bVar2) {
        this.Dk = bVar;
        this.Dl = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> hK() {
        return new com.airbnb.lottie.a.b.m(this.Dk.hK(), this.Dl.hK());
    }
}
