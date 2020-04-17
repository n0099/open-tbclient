package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final GradientType DA;
    private final com.airbnb.lottie.model.a.c DD;
    private final com.airbnb.lottie.model.a.f DE;
    private final com.airbnb.lottie.model.a.f DG;
    private final com.airbnb.lottie.model.a.b DJ;
    private final ShapeStroke.LineCapType DK;
    private final ShapeStroke.LineJoinType DM;
    private final float DN;
    private final List<com.airbnb.lottie.model.a.b> DO;
    @Nullable
    private final com.airbnb.lottie.model.a.b DQ;
    private final com.airbnb.lottie.model.a.d Du;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.DA = gradientType;
        this.DD = cVar;
        this.Du = dVar;
        this.DE = fVar;
        this.DG = fVar2;
        this.DJ = bVar;
        this.DK = lineCapType;
        this.DM = lineJoinType;
        this.DN = f;
        this.DO = list;
        this.DQ = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType hW() {
        return this.DA;
    }

    public com.airbnb.lottie.model.a.c hY() {
        return this.DD;
    }

    public com.airbnb.lottie.model.a.d hQ() {
        return this.Du;
    }

    public com.airbnb.lottie.model.a.f hZ() {
        return this.DE;
    }

    public com.airbnb.lottie.model.a.f ia() {
        return this.DG;
    }

    public com.airbnb.lottie.model.a.b ib() {
        return this.DJ;
    }

    public ShapeStroke.LineCapType ic() {
        return this.DK;
    }

    public ShapeStroke.LineJoinType ie() {
        return this.DM;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.airbnb.lottie.model.a.b> m8if() {
        return this.DO;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b ig() {
        return this.DQ;
    }

    public float ih() {
        return this.DN;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
