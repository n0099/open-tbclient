package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes7.dex */
public class i implements m<PointF, PointF> {
    private final b FE;
    private final b FF;

    public i(b bVar, b bVar2) {
        this.FE = bVar;
        this.FF = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> jD() {
        return new com.airbnb.lottie.a.b.m(this.FE.jD(), this.FF.jD());
    }
}
