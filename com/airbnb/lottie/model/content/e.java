package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d hS;
    private final GradientType hY;
    private final com.airbnb.lottie.model.a.c ib;
    private final com.airbnb.lottie.model.a.f ic;
    private final com.airbnb.lottie.model.a.f ie;
    private final com.airbnb.lottie.model.a.b ii;
    private final ShapeStroke.LineCapType ij;
    private final ShapeStroke.LineJoinType ik;
    private final float il;
    private final List<com.airbnb.lottie.model.a.b> im;
    @Nullable

    /* renamed from: io  reason: collision with root package name */
    private final com.airbnb.lottie.model.a.b f971io;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.hY = gradientType;
        this.ib = cVar;
        this.hS = dVar;
        this.ic = fVar;
        this.ie = fVar2;
        this.ii = bVar;
        this.ij = lineCapType;
        this.ik = lineJoinType;
        this.il = f;
        this.im = list;
        this.f971io = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cz() {
        return this.hY;
    }

    public com.airbnb.lottie.model.a.c cB() {
        return this.ib;
    }

    public com.airbnb.lottie.model.a.d ct() {
        return this.hS;
    }

    public com.airbnb.lottie.model.a.f cC() {
        return this.ic;
    }

    public com.airbnb.lottie.model.a.f cD() {
        return this.ie;
    }

    public com.airbnb.lottie.model.a.b cE() {
        return this.ii;
    }

    public ShapeStroke.LineCapType cF() {
        return this.ij;
    }

    public ShapeStroke.LineJoinType cG() {
        return this.ik;
    }

    public List<com.airbnb.lottie.model.a.b> cH() {
        return this.im;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b cI() {
        return this.f971io;
    }

    public float cJ() {
        return this.il;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
