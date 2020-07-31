package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes20.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.e.a<PointF>> CL;

    public e() {
        this.CL = Collections.singletonList(new com.airbnb.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.airbnb.lottie.e.a<PointF>> list) {
        this.CL = list;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> ia() {
        return this.CL.get(0).jB() ? new com.airbnb.lottie.a.b.j(this.CL) : new com.airbnb.lottie.a.b.i(this.CL);
    }
}
