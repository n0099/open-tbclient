package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {
    private final m<PointF, PointF> hO;
    private final com.airbnb.lottie.model.a.f hU;
    private final boolean hV;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.hO = mVar;
        this.hU = fVar;
        this.hV = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> cq() {
        return this.hO;
    }

    public com.airbnb.lottie.model.a.f cx() {
        return this.hU;
    }

    public boolean isReversed() {
        return this.hV;
    }
}
