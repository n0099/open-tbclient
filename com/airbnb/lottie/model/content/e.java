package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d FB;
    private final GradientType FI;
    private final com.airbnb.lottie.model.a.c FK;
    private final com.airbnb.lottie.model.a.f FL;
    private final com.airbnb.lottie.model.a.f FM;
    private final com.airbnb.lottie.model.a.b FP;
    private final ShapeStroke.LineCapType FQ;
    private final ShapeStroke.LineJoinType FR;
    private final float FT;
    private final List<com.airbnb.lottie.model.a.b> FU;
    @Nullable
    private final com.airbnb.lottie.model.a.b FV;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.FI = gradientType;
        this.FK = cVar;
        this.FB = dVar;
        this.FL = fVar;
        this.FM = fVar2;
        this.FP = bVar;
        this.FQ = lineCapType;
        this.FR = lineJoinType;
        this.FT = f;
        this.FU = list;
        this.FV = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jo() {
        return this.FI;
    }

    public com.airbnb.lottie.model.a.c jq() {
        return this.FK;
    }

    public com.airbnb.lottie.model.a.d ji() {
        return this.FB;
    }

    public com.airbnb.lottie.model.a.f jr() {
        return this.FL;
    }

    public com.airbnb.lottie.model.a.f js() {
        return this.FM;
    }

    public com.airbnb.lottie.model.a.b jt() {
        return this.FP;
    }

    public ShapeStroke.LineCapType ju() {
        return this.FQ;
    }

    public ShapeStroke.LineJoinType jv() {
        return this.FR;
    }

    public List<com.airbnb.lottie.model.a.b> jw() {
        return this.FU;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b jx() {
        return this.FV;
    }

    public float jy() {
        return this.FT;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
