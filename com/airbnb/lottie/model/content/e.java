package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes10.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d EY;
    private final GradientType Fe;
    private final com.airbnb.lottie.model.a.c Fg;
    private final com.airbnb.lottie.model.a.f Fh;
    private final com.airbnb.lottie.model.a.f Fi;
    private final com.airbnb.lottie.model.a.b Fl;
    private final ShapeStroke.LineCapType Fm;
    private final ShapeStroke.LineJoinType Fn;
    private final float Fo;
    private final List<com.airbnb.lottie.model.a.b> Fp;
    @Nullable
    private final com.airbnb.lottie.model.a.b Fq;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.Fe = gradientType;
        this.Fg = cVar;
        this.EY = dVar;
        this.Fh = fVar;
        this.Fi = fVar2;
        this.Fl = bVar;
        this.Fm = lineCapType;
        this.Fn = lineJoinType;
        this.Fo = f;
        this.Fp = list;
        this.Fq = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jP() {
        return this.Fe;
    }

    public com.airbnb.lottie.model.a.c jR() {
        return this.Fg;
    }

    public com.airbnb.lottie.model.a.d jJ() {
        return this.EY;
    }

    public com.airbnb.lottie.model.a.f jS() {
        return this.Fh;
    }

    public com.airbnb.lottie.model.a.f jT() {
        return this.Fi;
    }

    public com.airbnb.lottie.model.a.b jU() {
        return this.Fl;
    }

    public ShapeStroke.LineCapType jV() {
        return this.Fm;
    }

    public ShapeStroke.LineJoinType jW() {
        return this.Fn;
    }

    public List<com.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b jY() {
        return this.Fq;
    }

    public float jZ() {
        return this.Fo;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
