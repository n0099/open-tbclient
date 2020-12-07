package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.e.a<PointF>> EF;

    public e() {
        this.EF = Collections.singletonList(new com.airbnb.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.airbnb.lottie.e.a<PointF>> list) {
        this.EF = list;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> jD() {
        return this.EF.get(0).lc() ? new com.airbnb.lottie.a.b.j(this.EF) : new com.airbnb.lottie.a.b.i(this.EF);
    }
}
