package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class i implements m<PointF, PointF> {
    private final b nC;
    private final b nD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, b bVar2) {
        this.nC = bVar;
        this.nD = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> ck() {
        return new com.airbnb.lottie.a.b.m(this.nC.ck(), this.nD.ck());
    }
}
