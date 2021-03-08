package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class a implements b {
    private final m<PointF, PointF> GR;
    private final com.airbnb.lottie.model.a.f GZ;
    private final boolean Ha;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.GR = mVar;
        this.GZ = fVar;
        this.Ha = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> je() {
        return this.GR;
    }

    public com.airbnb.lottie.model.a.f jl() {
        return this.GZ;
    }

    public boolean isReversed() {
        return this.Ha;
    }
}
