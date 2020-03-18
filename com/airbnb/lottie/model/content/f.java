package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final m<PointF, PointF> hO;
    private final com.airbnb.lottie.model.a.f hU;
    private final com.airbnb.lottie.model.a.b iD;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.hO = mVar;
        this.hU = fVar;
        this.iD = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b cT() {
        return this.iD;
    }

    public com.airbnb.lottie.model.a.f cx() {
        return this.hU;
    }

    public m<PointF, PointF> cq() {
        return this.hO;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.hO + ", size=" + this.hU + '}';
    }
}
