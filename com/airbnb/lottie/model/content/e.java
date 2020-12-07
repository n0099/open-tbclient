package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes7.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d FO;
    private final GradientType FW;
    private final com.airbnb.lottie.model.a.c FY;
    private final com.airbnb.lottie.model.a.f FZ;
    private final com.airbnb.lottie.model.a.f Ga;
    private final com.airbnb.lottie.model.a.b Gd;
    private final ShapeStroke.LineCapType Ge;
    private final ShapeStroke.LineJoinType Gf;
    private final float Gg;
    private final List<com.airbnb.lottie.model.a.b> Gh;
    @Nullable
    private final com.airbnb.lottie.model.a.b Gi;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.FW = gradientType;
        this.FY = cVar;
        this.FO = dVar;
        this.FZ = fVar;
        this.Ga = fVar2;
        this.Gd = bVar;
        this.Ge = lineCapType;
        this.Gf = lineJoinType;
        this.Gg = f;
        this.Gh = list;
        this.Gi = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jP() {
        return this.FW;
    }

    public com.airbnb.lottie.model.a.c jR() {
        return this.FY;
    }

    public com.airbnb.lottie.model.a.d jJ() {
        return this.FO;
    }

    public com.airbnb.lottie.model.a.f jS() {
        return this.FZ;
    }

    public com.airbnb.lottie.model.a.f jT() {
        return this.Ga;
    }

    public com.airbnb.lottie.model.a.b jU() {
        return this.Gd;
    }

    public ShapeStroke.LineCapType jV() {
        return this.Ge;
    }

    public ShapeStroke.LineJoinType jW() {
        return this.Gf;
    }

    public List<com.airbnb.lottie.model.a.b> jX() {
        return this.Gh;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b jY() {
        return this.Gi;
    }

    public float jZ() {
        return this.Gg;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
