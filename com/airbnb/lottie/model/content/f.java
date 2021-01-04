package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes3.dex */
public class f implements b {
    private final com.airbnb.lottie.model.a.f FE;
    private final m<PointF, PointF> Fy;
    private final com.airbnb.lottie.model.a.b Ge;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.Fy = mVar;
        this.FE = fVar;
        this.Ge = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b jI() {
        return this.Ge;
    }

    public com.airbnb.lottie.model.a.f jm() {
        return this.FE;
    }

    public m<PointF, PointF> jf() {
        return this.Fy;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.Fy + ", size=" + this.FE + '}';
    }
}
