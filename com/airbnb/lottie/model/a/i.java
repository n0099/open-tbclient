package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class i implements m<PointF, PointF> {
    private final b gA;
    private final b gB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, b bVar2) {
        this.gA = bVar;
        this.gB = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> bY() {
        return new com.airbnb.lottie.a.b.m(this.gA.bY(), this.gB.bY());
    }
}
