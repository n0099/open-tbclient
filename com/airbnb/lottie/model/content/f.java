package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class f implements b {
    private final m<PointF, PointF> GR;
    private final com.airbnb.lottie.model.a.f GZ;
    private final com.airbnb.lottie.model.a.b Hy;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.GR = mVar;
        this.GZ = fVar;
        this.Hy = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b jH() {
        return this.Hy;
    }

    public com.airbnb.lottie.model.a.f jl() {
        return this.GZ;
    }

    public m<PointF, PointF> je() {
        return this.GR;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.GR + ", size=" + this.GZ + '}';
    }
}
