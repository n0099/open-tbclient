package com.baidu.live.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes9.dex */
public class e implements b {
    private final float FQ;
    private final List<com.baidu.live.lottie.model.a.b> FR;
    private final com.baidu.live.lottie.model.a.d bpX;
    private final GradientType bqb;
    private final com.baidu.live.lottie.model.a.c bqc;
    private final com.baidu.live.lottie.model.a.f bqd;
    private final com.baidu.live.lottie.model.a.f bqe;
    private final com.baidu.live.lottie.model.a.b bqh;
    private final ShapeStroke.LineCapType bqi;
    private final ShapeStroke.LineJoinType bqj;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bqk;
    private final String name;

    public e(String str, GradientType gradientType, com.baidu.live.lottie.model.a.c cVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.f fVar2, com.baidu.live.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.baidu.live.lottie.model.a.b> list, @Nullable com.baidu.live.lottie.model.a.b bVar2) {
        this.name = str;
        this.bqb = gradientType;
        this.bqc = cVar;
        this.bpX = dVar;
        this.bqd = fVar;
        this.bqe = fVar2;
        this.bqh = bVar;
        this.bqi = lineCapType;
        this.bqj = lineJoinType;
        this.FQ = f;
        this.FR = list;
        this.bqk = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType Mf() {
        return this.bqb;
    }

    public com.baidu.live.lottie.model.a.c Mg() {
        return this.bqc;
    }

    public com.baidu.live.lottie.model.a.d Ma() {
        return this.bpX;
    }

    public com.baidu.live.lottie.model.a.f Mh() {
        return this.bqd;
    }

    public com.baidu.live.lottie.model.a.f Mi() {
        return this.bqe;
    }

    public com.baidu.live.lottie.model.a.b Mj() {
        return this.bqh;
    }

    public ShapeStroke.LineCapType Mk() {
        return this.bqi;
    }

    public ShapeStroke.LineJoinType Ml() {
        return this.bqj;
    }

    public List<com.baidu.live.lottie.model.a.b> jw() {
        return this.FR;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.b Mm() {
        return this.bqk;
    }

    public float jy() {
        return this.FQ;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.h(hVar, aVar, this);
    }
}
