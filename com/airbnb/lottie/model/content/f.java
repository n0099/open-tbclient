package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes10.dex */
public class f implements b {
    private final m<PointF, PointF> EV;
    private final com.airbnb.lottie.model.a.f Fb;
    private final com.airbnb.lottie.model.a.b Fz;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.EV = mVar;
        this.Fb = fVar;
        this.Fz = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b kj() {
        return this.Fz;
    }

    public com.airbnb.lottie.model.a.f jN() {
        return this.Fb;
    }

    public m<PointF, PointF> jG() {
        return this.EV;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.EV + ", size=" + this.Fb + '}';
    }
}
