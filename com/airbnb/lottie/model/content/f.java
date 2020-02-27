package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final m<PointF, PointF> hP;
    private final com.airbnb.lottie.model.a.f hV;
    private final com.airbnb.lottie.model.a.b iE;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.hP = mVar;
        this.hV = fVar;
        this.iE = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b cT() {
        return this.iE;
    }

    public com.airbnb.lottie.model.a.f cx() {
        return this.hV;
    }

    public m<PointF, PointF> cq() {
        return this.hP;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.hP + ", size=" + this.hV + '}';
    }
}
