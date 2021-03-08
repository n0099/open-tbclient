package com.baidu.live.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes9.dex */
public class e implements b {
    private final float Hn;
    private final List<com.baidu.live.lottie.model.a.b> Ho;
    private final com.baidu.live.lottie.model.a.d bva;
    private final GradientType bve;
    private final com.baidu.live.lottie.model.a.c bvf;
    private final com.baidu.live.lottie.model.a.f bvg;
    private final com.baidu.live.lottie.model.a.f bvh;
    private final com.baidu.live.lottie.model.a.b bvk;
    private final ShapeStroke.LineCapType bvl;
    private final ShapeStroke.LineJoinType bvm;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bvn;
    private final String name;

    public e(String str, GradientType gradientType, com.baidu.live.lottie.model.a.c cVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.f fVar2, com.baidu.live.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.baidu.live.lottie.model.a.b> list, @Nullable com.baidu.live.lottie.model.a.b bVar2) {
        this.name = str;
        this.bve = gradientType;
        this.bvf = cVar;
        this.bva = dVar;
        this.bvg = fVar;
        this.bvh = fVar2;
        this.bvk = bVar;
        this.bvl = lineCapType;
        this.bvm = lineJoinType;
        this.Hn = f;
        this.Ho = list;
        this.bvn = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType NG() {
        return this.bve;
    }

    public com.baidu.live.lottie.model.a.c NH() {
        return this.bvf;
    }

    public com.baidu.live.lottie.model.a.d NB() {
        return this.bva;
    }

    public com.baidu.live.lottie.model.a.f NI() {
        return this.bvg;
    }

    public com.baidu.live.lottie.model.a.f NJ() {
        return this.bvh;
    }

    public com.baidu.live.lottie.model.a.b NK() {
        return this.bvk;
    }

    public ShapeStroke.LineCapType NL() {
        return this.bvl;
    }

    public ShapeStroke.LineJoinType NM() {
        return this.bvm;
    }

    public List<com.baidu.live.lottie.model.a.b> jv() {
        return this.Ho;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.b NN() {
        return this.bvn;
    }

    public float jx() {
        return this.Hn;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.h(hVar, aVar, this);
    }
}
