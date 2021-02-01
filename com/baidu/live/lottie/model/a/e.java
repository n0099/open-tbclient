package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class e implements m<PointF, PointF> {
    private final List<com.baidu.live.lottie.e.a<PointF>> Es;

    public e() {
        this.Es = Collections.singletonList(new com.baidu.live.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.baidu.live.lottie.e.a<PointF>> list) {
        this.Es = list;
    }

    @Override // com.baidu.live.lottie.model.a.m
    public com.baidu.live.lottie.a.b.a<PointF, PointF> Ns() {
        return this.Es.get(0).kA() ? new com.baidu.live.lottie.a.b.j(this.Es) : new com.baidu.live.lottie.a.b.i(this.Es);
    }
}
