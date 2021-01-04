package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class e implements m<PointF, PointF> {
    private final List<com.baidu.live.lottie.e.a<PointF>> Eu;

    public e() {
        this.Eu = Collections.singletonList(new com.baidu.live.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.baidu.live.lottie.e.a<PointF>> list) {
        this.Eu = list;
    }

    @Override // com.baidu.live.lottie.model.a.m
    public com.baidu.live.lottie.a.b.a<PointF, PointF> PP() {
        return this.Eu.get(0).kB() ? new com.baidu.live.lottie.a.b.j(this.Eu) : new com.baidu.live.lottie.a.b.i(this.Eu);
    }
}
