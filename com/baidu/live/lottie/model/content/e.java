package com.baidu.live.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes10.dex */
public class e implements b {
    private final float FQ;
    private final List<com.baidu.live.lottie.model.a.b> FR;
    private final GradientType btD;
    private final com.baidu.live.lottie.model.a.c btE;
    private final com.baidu.live.lottie.model.a.f btF;
    private final com.baidu.live.lottie.model.a.f btG;
    private final com.baidu.live.lottie.model.a.b btJ;
    private final ShapeStroke.LineCapType btK;
    private final ShapeStroke.LineJoinType btL;
    @Nullable
    private final com.baidu.live.lottie.model.a.b btM;
    private final com.baidu.live.lottie.model.a.d btz;
    private final String name;

    public e(String str, GradientType gradientType, com.baidu.live.lottie.model.a.c cVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.f fVar2, com.baidu.live.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.baidu.live.lottie.model.a.b> list, @Nullable com.baidu.live.lottie.model.a.b bVar2) {
        this.name = str;
        this.btD = gradientType;
        this.btE = cVar;
        this.btz = dVar;
        this.btF = fVar;
        this.btG = fVar2;
        this.btJ = bVar;
        this.btK = lineCapType;
        this.btL = lineJoinType;
        this.FQ = f;
        this.FR = list;
        this.btM = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType ND() {
        return this.btD;
    }

    public com.baidu.live.lottie.model.a.c NE() {
        return this.btE;
    }

    public com.baidu.live.lottie.model.a.d Ny() {
        return this.btz;
    }

    public com.baidu.live.lottie.model.a.f NF() {
        return this.btF;
    }

    public com.baidu.live.lottie.model.a.f NG() {
        return this.btG;
    }

    public com.baidu.live.lottie.model.a.b NH() {
        return this.btJ;
    }

    public ShapeStroke.LineCapType NI() {
        return this.btK;
    }

    public ShapeStroke.LineJoinType NJ() {
        return this.btL;
    }

    public List<com.baidu.live.lottie.model.a.b> jv() {
        return this.FR;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.b NK() {
        return this.btM;
    }

    public float jx() {
        return this.FQ;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.h(hVar, aVar, this);
    }
}
