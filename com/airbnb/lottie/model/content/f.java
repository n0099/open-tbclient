package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes20.dex */
public class f implements b {
    private final m<PointF, PointF> DY;
    private final com.airbnb.lottie.model.a.b ED;
    private final com.airbnb.lottie.model.a.f Ee;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.DY = mVar;
        this.Ee = fVar;
        this.ED = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b iI() {
        return this.ED;
    }

    public com.airbnb.lottie.model.a.f il() {
        return this.Ee;
    }

    public m<PointF, PointF> ie() {
        return this.DY;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.DY + ", size=" + this.Ee + '}';
    }
}
