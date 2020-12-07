package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes7.dex */
public class a implements b {
    private final m<PointF, PointF> FL;
    private final com.airbnb.lottie.model.a.f FR;
    private final boolean FT;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.FL = mVar;
        this.FR = fVar;
        this.FT = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> jG() {
        return this.FL;
    }

    public com.airbnb.lottie.model.a.f jN() {
        return this.FR;
    }

    public boolean isReversed() {
        return this.FT;
    }
}
