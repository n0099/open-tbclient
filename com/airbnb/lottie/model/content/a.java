package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes3.dex */
public class a implements b {
    private final com.airbnb.lottie.model.a.f FE;
    private final boolean FF;
    private final m<PointF, PointF> Fy;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.Fy = mVar;
        this.FE = fVar;
        this.FF = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> jf() {
        return this.Fy;
    }

    public com.airbnb.lottie.model.a.f jm() {
        return this.FE;
    }

    public boolean isReversed() {
        return this.FF;
    }
}
