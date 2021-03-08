package com.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes5.dex */
public class i implements m<PointF, PointF> {
    private final b GK;
    private final b GL;

    public i(b bVar, b bVar2) {
        this.GK = bVar;
        this.GL = bVar2;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> jb() {
        return new com.airbnb.lottie.a.b.m(this.GK.jb(), this.GL.jb());
    }
}
