package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes4.dex */
public class f implements b {
    private final m<PointF, PointF> hL;
    private final com.airbnb.lottie.model.a.f hR;
    private final com.airbnb.lottie.model.a.b iB;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.hL = mVar;
        this.hR = fVar;
        this.iB = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b cS() {
        return this.iB;
    }

    public com.airbnb.lottie.model.a.f cw() {
        return this.hR;
    }

    public m<PointF, PointF> cp() {
        return this.hL;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.hL + ", size=" + this.hR + '}';
    }
}
