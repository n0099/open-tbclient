package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d Eb;
    private final GradientType Eh;
    private final com.airbnb.lottie.model.a.c Ej;
    private final com.airbnb.lottie.model.a.f Ek;
    private final com.airbnb.lottie.model.a.f El;
    private final com.airbnb.lottie.model.a.b Eo;
    private final ShapeStroke.LineCapType Ep;
    private final ShapeStroke.LineJoinType Eq;
    private final float Er;
    private final List<com.airbnb.lottie.model.a.b> Es;
    @Nullable
    private final com.airbnb.lottie.model.a.b Et;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.Eh = gradientType;
        this.Ej = cVar;
        this.Eb = dVar;
        this.Ek = fVar;
        this.El = fVar2;
        this.Eo = bVar;
        this.Ep = lineCapType;
        this.Eq = lineJoinType;
        this.Er = f;
        this.Es = list;
        this.Et = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType in() {
        return this.Eh;
    }

    public com.airbnb.lottie.model.a.c iq() {
        return this.Ej;
    }

    public com.airbnb.lottie.model.a.d ih() {
        return this.Eb;
    }

    public com.airbnb.lottie.model.a.f ir() {
        return this.Ek;
    }

    public com.airbnb.lottie.model.a.f is() {
        return this.El;
    }

    public com.airbnb.lottie.model.a.b it() {
        return this.Eo;
    }

    public ShapeStroke.LineCapType iu() {
        return this.Ep;
    }

    public ShapeStroke.LineJoinType iv() {
        return this.Eq;
    }

    public List<com.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b ix() {
        return this.Et;
    }

    public float iy() {
        return this.Er;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
