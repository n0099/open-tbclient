package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.e.a<PointF>> CJ;

    public e() {
        this.CJ = Collections.singletonList(new com.airbnb.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.airbnb.lottie.e.a<PointF>> list) {
        this.CJ = list;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> ia() {
        return this.CJ.get(0).jB() ? new com.airbnb.lottie.a.b.j(this.CJ) : new com.airbnb.lottie.a.b.i(this.CJ);
    }
}
