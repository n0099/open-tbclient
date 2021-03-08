package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d GW;
    private final GradientType Hd;
    private final com.airbnb.lottie.model.a.c Hf;
    private final com.airbnb.lottie.model.a.f Hg;
    private final com.airbnb.lottie.model.a.f Hh;
    private final com.airbnb.lottie.model.a.b Hk;
    private final ShapeStroke.LineCapType Hl;
    private final ShapeStroke.LineJoinType Hm;
    private final float Hn;
    private final List<com.airbnb.lottie.model.a.b> Ho;
    @Nullable
    private final com.airbnb.lottie.model.a.b Hp;
    private final String name;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.Hd = gradientType;
        this.Hf = cVar;
        this.GW = dVar;
        this.Hg = fVar;
        this.Hh = fVar2;
        this.Hk = bVar;
        this.Hl = lineCapType;
        this.Hm = lineJoinType;
        this.Hn = f;
        this.Ho = list;
        this.Hp = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jn() {
        return this.Hd;
    }

    public com.airbnb.lottie.model.a.c jp() {
        return this.Hf;
    }

    public com.airbnb.lottie.model.a.d jh() {
        return this.GW;
    }

    public com.airbnb.lottie.model.a.f jq() {
        return this.Hg;
    }

    public com.airbnb.lottie.model.a.f jr() {
        return this.Hh;
    }

    public com.airbnb.lottie.model.a.b js() {
        return this.Hk;
    }

    public ShapeStroke.LineCapType jt() {
        return this.Hl;
    }

    public ShapeStroke.LineJoinType ju() {
        return this.Hm;
    }

    public List<com.airbnb.lottie.model.a.b> jv() {
        return this.Ho;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b jw() {
        return this.Hp;
    }

    public float jx() {
        return this.Hn;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
