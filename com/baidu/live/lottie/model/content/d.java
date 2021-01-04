package com.baidu.live.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class d implements b {
    private final Path.FillType FJ;
    private final com.baidu.live.lottie.model.a.d buL;
    private final GradientType buP;
    private final com.baidu.live.lottie.model.a.c buQ;
    private final com.baidu.live.lottie.model.a.f buR;
    private final com.baidu.live.lottie.model.a.f buS;
    @Nullable
    private final com.baidu.live.lottie.model.a.b buT;
    @Nullable
    private final com.baidu.live.lottie.model.a.b buU;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.baidu.live.lottie.model.a.c cVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.f fVar2, com.baidu.live.lottie.model.a.b bVar, com.baidu.live.lottie.model.a.b bVar2) {
        this.buP = gradientType;
        this.FJ = fillType;
        this.buQ = cVar;
        this.buL = dVar;
        this.buR = fVar;
        this.buS = fVar2;
        this.name = str;
        this.buT = bVar;
        this.buU = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType Qa() {
        return this.buP;
    }

    public Path.FillType jp() {
        return this.FJ;
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

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.g(hVar, aVar, this);
    }
}
