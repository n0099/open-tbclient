package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {
    private final com.airbnb.lottie.model.a.f DA;
    private final boolean DC;
    private final m<PointF, PointF> Du;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.Du = mVar;
        this.DA = fVar;
        this.DC = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> hN() {
        return this.Du;
    }

    public com.airbnb.lottie.model.a.f hU() {
        return this.DA;
    }

    public boolean isReversed() {
        return this.DC;
    }
}
