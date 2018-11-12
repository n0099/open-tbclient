package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class i implements m<PointF, PointF> {
    private final b qI;
    private final b qJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, b bVar2) {
        this.qI = bVar;
        this.qJ = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> dG() {
        return new com.airbnb.lottie.a.b.m(this.qI.dG(), this.qJ.dG());
    }
}
