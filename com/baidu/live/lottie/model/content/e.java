package com.baidu.live.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes10.dex */
public class e implements b {
    private final float FT;
    private final List<com.baidu.live.lottie.model.a.b> FU;
    private final com.baidu.live.lottie.model.a.d buL;
    private final GradientType buP;
    private final com.baidu.live.lottie.model.a.c buQ;
    private final com.baidu.live.lottie.model.a.f buR;
    private final com.baidu.live.lottie.model.a.f buS;
    private final com.baidu.live.lottie.model.a.b buV;
    private final ShapeStroke.LineCapType buW;
    private final ShapeStroke.LineJoinType buX;
    @Nullable
    private final com.baidu.live.lottie.model.a.b buY;
    private final String name;

    public e(String str, GradientType gradientType, com.baidu.live.lottie.model.a.c cVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.f fVar2, com.baidu.live.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.baidu.live.lottie.model.a.b> list, @Nullable com.baidu.live.lottie.model.a.b bVar2) {
        this.name = str;
        this.buP = gradientType;
        this.buQ = cVar;
        this.buL = dVar;
        this.buR = fVar;
        this.buS = fVar2;
        this.buV = bVar;
        this.buW = lineCapType;
        this.buX = lineJoinType;
        this.FT = f;
        this.FU = list;
        this.buY = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType Qa() {
        return this.buP;
    }

    public com.baidu.live.lottie.model.a.c Qb() {
        return this.buQ;
    }

    public com.baidu.live.lottie.model.a.d PV() {
        return this.buL;
    }

    public com.baidu.live.lottie.model.a.f Qc() {
        return this.buR;
    }

    public com.baidu.live.lottie.model.a.f Qd() {
        return this.buS;
    }

    public com.baidu.live.lottie.model.a.b Qe() {
        return this.buV;
    }

    public ShapeStroke.LineCapType Qf() {
        return this.buW;
    }

    public ShapeStroke.LineJoinType Qg() {
        return this.buX;
    }

    public List<com.baidu.live.lottie.model.a.b> jw() {
        return this.FU;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.b Qh() {
        return this.buY;
    }

    public float jy() {
        return this.FT;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.h(hVar, aVar, this);
    }
}
