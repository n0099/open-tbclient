package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes9.dex */
public class i implements m<PointF, PointF> {
    private final b buQ;
    private final b buR;

    public i(b bVar, b bVar2) {
        this.buQ = bVar;
        this.buR = bVar2;
    }

    @Override // com.baidu.live.lottie.model.a.m
    public com.baidu.live.lottie.a.b.a<PointF, PointF> Nv() {
        return new com.baidu.live.lottie.a.b.m(this.buQ.Nv(), this.buR.Nv());
    }
}
