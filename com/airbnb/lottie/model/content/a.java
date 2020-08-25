package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes18.dex */
public class a implements b {
    private final m<PointF, PointF> ED;
    private final com.airbnb.lottie.model.a.f EJ;
    private final boolean EK;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.ED = mVar;
        this.EJ = fVar;
        this.EK = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> jE() {
        return this.ED;
    }

    public com.airbnb.lottie.model.a.f jL() {
        return this.EJ;
    }

    public boolean isReversed() {
        return this.EK;
    }
}
