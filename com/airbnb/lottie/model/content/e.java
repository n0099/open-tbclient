package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d hO;
    private final GradientType hU;
    private final com.airbnb.lottie.model.a.c hW;
    private final com.airbnb.lottie.model.a.f hX;
    private final com.airbnb.lottie.model.a.f hY;
    private final com.airbnb.lottie.model.a.b ic;
    private final ShapeStroke.LineCapType ie;

    /* renamed from: if  reason: not valid java name */
    private final ShapeStroke.LineJoinType f2if;
    private final float ig;
    private final List<com.airbnb.lottie.model.a.b> ii;
    @Nullable
    private final com.airbnb.lottie.model.a.b ij;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.hU = gradientType;
        this.hW = cVar;
        this.hO = dVar;
        this.hX = fVar;
        this.hY = fVar2;
        this.ic = bVar;
        this.ie = lineCapType;
        this.f2if = lineJoinType;
        this.ig = f;
        this.ii = list;
        this.ij = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cy() {
        return this.hU;
    }

    public com.airbnb.lottie.model.a.c cA() {
        return this.hW;
    }

    public com.airbnb.lottie.model.a.d cs() {
        return this.hO;
    }

    public com.airbnb.lottie.model.a.f cB() {
        return this.hX;
    }

    public com.airbnb.lottie.model.a.f cC() {
        return this.hY;
    }

    public com.airbnb.lottie.model.a.b cD() {
        return this.ic;
    }

    public ShapeStroke.LineCapType cE() {
        return this.ie;
    }

    public ShapeStroke.LineJoinType cF() {
        return this.f2if;
    }

    public List<com.airbnb.lottie.model.a.b> cG() {
        return this.ii;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b cH() {
        return this.ij;
    }

    public float cI() {
        return this.ig;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
