package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {
    private final m<PointF, PointF> hP;
    private final com.airbnb.lottie.model.a.f hV;
    private final boolean hW;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.hP = mVar;
        this.hV = fVar;
        this.hW = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> cq() {
        return this.hP;
    }

    public com.airbnb.lottie.model.a.f cx() {
        return this.hV;
    }

    public boolean isReversed() {
        return this.hW;
    }
}
