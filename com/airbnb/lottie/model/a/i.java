package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b Dn;
    private final b Do;

    public i(b bVar, b bVar2) {
        this.Dn = bVar;
        this.Do = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> hK() {
        return new com.airbnb.lottie.a.b.m(this.Dn.hK(), this.Do.hK());
    }
}
