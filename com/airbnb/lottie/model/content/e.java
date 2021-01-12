package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements b {
    private final GradientType FG;
    private final com.airbnb.lottie.model.a.c FI;
    private final com.airbnb.lottie.model.a.f FJ;
    private final com.airbnb.lottie.model.a.f FK;
    private final com.airbnb.lottie.model.a.b FN;
    private final ShapeStroke.LineCapType FO;
    private final ShapeStroke.LineJoinType FP;
    private final float FQ;
    private final List<com.airbnb.lottie.model.a.b> FR;
    @Nullable
    private final com.airbnb.lottie.model.a.b FT;
    private final com.airbnb.lottie.model.a.d Fz;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.FG = gradientType;
        this.FI = cVar;
        this.Fz = dVar;
        this.FJ = fVar;
        this.FK = fVar2;
        this.FN = bVar;
        this.FO = lineCapType;
        this.FP = lineJoinType;
        this.FQ = f;
        this.FR = list;
        this.FT = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jo() {
        return this.FG;
    }

    public com.airbnb.lottie.model.a.c jq() {
        return this.FI;
    }

    public com.airbnb.lottie.model.a.d ji() {
        return this.Fz;
    }

    public com.airbnb.lottie.model.a.f jr() {
        return this.FJ;
    }

    public com.airbnb.lottie.model.a.f js() {
        return this.FK;
    }

    public com.airbnb.lottie.model.a.b jt() {
        return this.FN;
    }

    public ShapeStroke.LineCapType ju() {
        return this.FO;
    }

    public ShapeStroke.LineJoinType jv() {
        return this.FP;
    }

    public List<com.airbnb.lottie.model.a.b> jw() {
        return this.FR;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b jx() {
        return this.FT;
    }

    public float jy() {
        return this.FQ;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
