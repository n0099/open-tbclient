package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes4.dex */
public class a implements b {
    private final m<PointF, PointF> hL;
    private final com.airbnb.lottie.model.a.f hR;
    private final boolean hS;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.hL = mVar;
        this.hR = fVar;
        this.hS = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> cp() {
        return this.hL;
    }

    public com.airbnb.lottie.model.a.f cw() {
        return this.hR;
    }

    public boolean isReversed() {
        return this.hS;
    }
}
