package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.e.a<PointF>> Es;

    public e() {
        this.Es = Collections.singletonList(new com.airbnb.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.airbnb.lottie.e.a<PointF>> list) {
        this.Es = list;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> jc() {
        return this.Es.get(0).kB() ? new com.airbnb.lottie.a.b.j(this.Es) : new com.airbnb.lottie.a.b.i(this.Es);
    }
}
