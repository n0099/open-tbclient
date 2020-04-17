package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {
    private final m<PointF, PointF> Dr;
    private final com.airbnb.lottie.model.a.f Dx;
    private final boolean Dy;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.Dr = mVar;
        this.Dx = fVar;
        this.Dy = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> hN() {
        return this.Dr;
    }

    public com.airbnb.lottie.model.a.f hU() {
        return this.Dx;
    }

    public boolean isReversed() {
        return this.Dy;
    }
}
