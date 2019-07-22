package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class i implements m<PointF, PointF> {
    private final b oe;
    private final b of;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, b bVar2) {
        this.oe = bVar;
        this.of = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> cF() {
        return new com.airbnb.lottie.a.b.m(this.oe.cF(), this.of.cF());
    }
}
