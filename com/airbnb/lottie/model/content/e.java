package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d hO;
    private final GradientType hV;
    private final com.airbnb.lottie.model.a.c hX;
    private final com.airbnb.lottie.model.a.f hY;
    private final com.airbnb.lottie.model.a.f hZ;
    private final com.airbnb.lottie.model.a.b ie;

    /* renamed from: if  reason: not valid java name */
    private final ShapeStroke.LineCapType f2if;
    private final ShapeStroke.LineJoinType ig;
    private final float ii;
    private final List<com.airbnb.lottie.model.a.b> ij;
    @Nullable
    private final com.airbnb.lottie.model.a.b ik;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.hV = gradientType;
        this.hX = cVar;
        this.hO = dVar;
        this.hY = fVar;
        this.hZ = fVar2;
        this.ie = bVar;
        this.f2if = lineCapType;
        this.ig = lineJoinType;
        this.ii = f;
        this.ij = list;
        this.ik = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cy() {
        return this.hV;
    }

    public com.airbnb.lottie.model.a.c cA() {
        return this.hX;
    }

    public com.airbnb.lottie.model.a.d cs() {
        return this.hO;
    }

    public com.airbnb.lottie.model.a.f cB() {
        return this.hY;
    }

    public com.airbnb.lottie.model.a.f cC() {
        return this.hZ;
    }

    public com.airbnb.lottie.model.a.b cD() {
        return this.ie;
    }

    public ShapeStroke.LineCapType cE() {
        return this.f2if;
    }

    public ShapeStroke.LineJoinType cF() {
        return this.ig;
    }

    public List<com.airbnb.lottie.model.a.b> cG() {
        return this.ij;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b cH() {
        return this.ik;
    }

    public float cI() {
        return this.ii;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
