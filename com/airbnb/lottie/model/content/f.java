package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final com.airbnb.lottie.model.a.b DZ;
    private final m<PointF, PointF> Dr;
    private final com.airbnb.lottie.model.a.f Dx;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.Dr = mVar;
        this.Dx = fVar;
        this.DZ = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b is() {
        return this.DZ;
    }

    public com.airbnb.lottie.model.a.f hU() {
        return this.Dx;
    }

    public m<PointF, PointF> hN() {
        return this.Dr;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.Dr + ", size=" + this.Dx + '}';
    }
}
