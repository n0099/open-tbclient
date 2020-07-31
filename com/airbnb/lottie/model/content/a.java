package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes20.dex */
public class a implements b {
    private final m<PointF, PointF> DY;
    private final com.airbnb.lottie.model.a.f Ee;
    private final boolean Ef;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.DY = mVar;
        this.Ee = fVar;
        this.Ef = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> ie() {
        return this.DY;
    }

    public com.airbnb.lottie.model.a.f il() {
        return this.Ee;
    }

    public boolean isReversed() {
        return this.Ef;
    }
}
