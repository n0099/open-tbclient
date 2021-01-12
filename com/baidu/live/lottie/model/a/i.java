package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes9.dex */
public class i implements m<PointF, PointF> {
    private final b bpN;
    private final b bpO;

    public i(b bVar, b bVar2) {
        this.bpN = bVar;
        this.bpO = bVar2;
    }

    @Override // com.baidu.live.lottie.model.a.m
    public com.baidu.live.lottie.a.b.a<PointF, PointF> LU() {
        return new com.baidu.live.lottie.a.b.m(this.bpN.LU(), this.bpO.LU());
    }
}
