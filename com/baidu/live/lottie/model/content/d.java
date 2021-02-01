package com.baidu.live.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class d implements b {
    private final Path.FillType FH;
    private final GradientType btD;
    private final com.baidu.live.lottie.model.a.c btE;
    private final com.baidu.live.lottie.model.a.f btF;
    private final com.baidu.live.lottie.model.a.f btG;
    @Nullable
    private final com.baidu.live.lottie.model.a.b btH;
    @Nullable
    private final com.baidu.live.lottie.model.a.b btI;
    private final com.baidu.live.lottie.model.a.d btz;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.baidu.live.lottie.model.a.c cVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.f fVar2, com.baidu.live.lottie.model.a.b bVar, com.baidu.live.lottie.model.a.b bVar2) {
        this.btD = gradientType;
        this.FH = fillType;
        this.btE = cVar;
        this.btz = dVar;
        this.btF = fVar;
        this.btG = fVar2;
        this.name = str;
        this.btH = bVar;
        this.btI = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType ND() {
        return this.btD;
    }

    public Path.FillType jo() {
        return this.FH;
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

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.g(hVar, aVar, this);
    }
}
