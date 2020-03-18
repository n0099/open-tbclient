package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d hR;
    private final GradientType hX;
    private final com.airbnb.lottie.model.a.c hZ;
    private final com.airbnb.lottie.model.a.f ib;
    private final com.airbnb.lottie.model.a.f ic;
    private final com.airbnb.lottie.model.a.b ig;
    private final ShapeStroke.LineCapType ii;
    private final ShapeStroke.LineJoinType ij;
    private final float ik;
    private final List<com.airbnb.lottie.model.a.b> il;
    @Nullable
    private final com.airbnb.lottie.model.a.b im;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.hX = gradientType;
        this.hZ = cVar;
        this.hR = dVar;
        this.ib = fVar;
        this.ic = fVar2;
        this.ig = bVar;
        this.ii = lineCapType;
        this.ij = lineJoinType;
        this.ik = f;
        this.il = list;
        this.im = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cz() {
        return this.hX;
    }

    public com.airbnb.lottie.model.a.c cB() {
        return this.hZ;
    }

    public com.airbnb.lottie.model.a.d ct() {
        return this.hR;
    }

    public com.airbnb.lottie.model.a.f cC() {
        return this.ib;
    }

    public com.airbnb.lottie.model.a.f cD() {
        return this.ic;
    }

    public com.airbnb.lottie.model.a.b cE() {
        return this.ig;
    }

    public ShapeStroke.LineCapType cF() {
        return this.ii;
    }

    public ShapeStroke.LineJoinType cG() {
        return this.ij;
    }

    public List<com.airbnb.lottie.model.a.b> cH() {
        return this.il;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b cI() {
        return this.im;
    }

    public float cJ() {
        return this.ik;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
