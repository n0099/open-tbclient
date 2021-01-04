package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes10.dex */
public class i implements m<PointF, PointF> {
    private final b buB;
    private final b buC;

    public i(b bVar, b bVar2) {
        this.buB = bVar;
        this.buC = bVar2;
    }

    @Override // com.baidu.live.lottie.model.a.m
    public com.baidu.live.lottie.a.b.a<PointF, PointF> PP() {
        return new com.baidu.live.lottie.a.b.m(this.buB.PP(), this.buC.PP());
    }
}
