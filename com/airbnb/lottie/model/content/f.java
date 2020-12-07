package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes7.dex */
public class f implements b {
    private final m<PointF, PointF> FL;
    private final com.airbnb.lottie.model.a.f FR;
    private final com.airbnb.lottie.model.a.b Gr;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.FL = mVar;
        this.FR = fVar;
        this.Gr = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b kj() {
        return this.Gr;
    }

    public com.airbnb.lottie.model.a.f jN() {
        return this.FR;
    }

    public m<PointF, PointF> jG() {
        return this.FL;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.FL + ", size=" + this.FR + '}';
    }
}
