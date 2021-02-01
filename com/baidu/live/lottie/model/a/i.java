package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes10.dex */
public class i implements m<PointF, PointF> {
    private final b btp;
    private final b btq;

    public i(b bVar, b bVar2) {
        this.btp = bVar;
        this.btq = bVar2;
    }

    @Override // com.baidu.live.lottie.model.a.m
    public com.baidu.live.lottie.a.b.a<PointF, PointF> Ns() {
        return new com.baidu.live.lottie.a.b.m(this.btp.Ns(), this.btq.Ns());
    }
}
