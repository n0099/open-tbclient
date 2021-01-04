package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes3.dex */
public class i implements m<PointF, PointF> {
    private final b Fr;
    private final b Fs;

    public i(b bVar, b bVar2) {
        this.Fr = bVar;
        this.Fs = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> jc() {
        return new com.airbnb.lottie.a.b.m(this.Fr.jc(), this.Fs.jc());
    }
}
