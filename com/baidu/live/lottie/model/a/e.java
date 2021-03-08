package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class e implements m<PointF, PointF> {
    private final List<com.baidu.live.lottie.e.a<PointF>> FL;

    public e() {
        this.FL = Collections.singletonList(new com.baidu.live.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.baidu.live.lottie.e.a<PointF>> list) {
        this.FL = list;
    }

    @Override // com.baidu.live.lottie.model.a.m
    public com.baidu.live.lottie.a.b.a<PointF, PointF> Nv() {
        return this.FL.get(0).kA() ? new com.baidu.live.lottie.a.b.j(this.FL) : new com.baidu.live.lottie.a.b.i(this.FL);
    }
}
