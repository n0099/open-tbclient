package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final GradientType DE;
    private final com.airbnb.lottie.model.a.c DH;
    private final com.airbnb.lottie.model.a.f DI;
    private final com.airbnb.lottie.model.a.f DJ;
    private final com.airbnb.lottie.model.a.b DN;
    private final ShapeStroke.LineCapType DO;
    private final ShapeStroke.LineJoinType DQ;
    private final float DR;
    private final List<com.airbnb.lottie.model.a.b> DS;
    @Nullable
    private final com.airbnb.lottie.model.a.b DT;
    private final com.airbnb.lottie.model.a.d Dx;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.DE = gradientType;
        this.DH = cVar;
        this.Dx = dVar;
        this.DI = fVar;
        this.DJ = fVar2;
        this.DN = bVar;
        this.DO = lineCapType;
        this.DQ = lineJoinType;
        this.DR = f;
        this.DS = list;
        this.DT = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType hW() {
        return this.DE;
    }

    public com.airbnb.lottie.model.a.c hY() {
        return this.DH;
    }

    public com.airbnb.lottie.model.a.d hQ() {
        return this.Dx;
    }

    public com.airbnb.lottie.model.a.f hZ() {
        return this.DI;
    }

    public com.airbnb.lottie.model.a.f ia() {
        return this.DJ;
    }

    public com.airbnb.lottie.model.a.b ib() {
        return this.DN;
    }

    public ShapeStroke.LineCapType ic() {
        return this.DO;
    }

    public ShapeStroke.LineJoinType ie() {
        return this.DQ;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.airbnb.lottie.model.a.b> m8if() {
        return this.DS;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b ig() {
        return this.DT;
    }

    public float ih() {
        return this.DR;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
