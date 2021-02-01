package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes4.dex */
public class a implements b {
    private final com.airbnb.lottie.model.a.f FC;
    private final boolean FD;
    private final m<PointF, PointF> Fw;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.Fw = mVar;
        this.FC = fVar;
        this.FD = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> je() {
        return this.Fw;
    }

    public com.airbnb.lottie.model.a.f jl() {
        return this.FC;
    }

    public boolean isReversed() {
        return this.FD;
    }
}
