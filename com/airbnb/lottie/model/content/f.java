package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes18.dex */
public class f implements b {
    private final m<PointF, PointF> ED;
    private final com.airbnb.lottie.model.a.f EJ;
    private final com.airbnb.lottie.model.a.b Fi;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.ED = mVar;
        this.EJ = fVar;
        this.Fi = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b kh() {
        return this.Fi;
    }

    public com.airbnb.lottie.model.a.f jL() {
        return this.EJ;
    }

    public m<PointF, PointF> jE() {
        return this.ED;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.ED + ", size=" + this.EJ + '}';
    }
}
