package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b hH;
    private final b hI;

    public i(b bVar, b bVar2) {
        this.hH = bVar;
        this.hI = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> cn() {
        return new com.airbnb.lottie.a.b.m(this.hH.cn(), this.hI.cn());
    }
}
