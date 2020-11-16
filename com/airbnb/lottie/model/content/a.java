package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class a implements b {
    private final m<PointF, PointF> EV;
    private final com.airbnb.lottie.model.a.f Fb;
    private final boolean Fc;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.EV = mVar;
        this.Fb = fVar;
        this.Fc = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> jG() {
        return this.EV;
    }

    public com.airbnb.lottie.model.a.f jN() {
        return this.Fb;
    }

    public boolean isReversed() {
        return this.Fc;
    }
}
