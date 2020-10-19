package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes10.dex */
public class i implements m<PointF, PointF> {
    private final b EN;
    private final b EO;

    public i(b bVar, b bVar2) {
        this.EN = bVar;
        this.EO = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> jD() {
        return new com.airbnb.lottie.a.b.m(this.EN.jD(), this.EO.jD());
    }
}
