package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d EG;
    private final GradientType EM;
    private final com.airbnb.lottie.model.a.c EO;
    private final com.airbnb.lottie.model.a.f EP;
    private final com.airbnb.lottie.model.a.f ER;
    private final com.airbnb.lottie.model.a.b EU;
    private final ShapeStroke.LineCapType EV;
    private final ShapeStroke.LineJoinType EW;
    private final float EX;
    private final List<com.airbnb.lottie.model.a.b> EY;
    @Nullable
    private final com.airbnb.lottie.model.a.b EZ;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.EM = gradientType;
        this.EO = cVar;
        this.EG = dVar;
        this.EP = fVar;
        this.ER = fVar2;
        this.EU = bVar;
        this.EV = lineCapType;
        this.EW = lineJoinType;
        this.EX = f;
        this.EY = list;
        this.EZ = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jO() {
        return this.EM;
    }

    public com.airbnb.lottie.model.a.c jQ() {
        return this.EO;
    }

    public com.airbnb.lottie.model.a.d jI() {
        return this.EG;
    }

    public com.airbnb.lottie.model.a.f jR() {
        return this.EP;
    }

    public com.airbnb.lottie.model.a.f jS() {
        return this.ER;
    }

    public com.airbnb.lottie.model.a.b jT() {
        return this.EU;
    }

    public ShapeStroke.LineCapType jU() {
        return this.EV;
    }

    public ShapeStroke.LineJoinType jV() {
        return this.EW;
    }

    public List<com.airbnb.lottie.model.a.b> jW() {
        return this.EY;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b jX() {
        return this.EZ;
    }

    public float jY() {
        return this.EX;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
