package com.baidu.live.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class d implements b {
    private final Path.FillType FH;
    private final com.baidu.live.lottie.model.a.d bpX;
    private final GradientType bqb;
    private final com.baidu.live.lottie.model.a.c bqc;
    private final com.baidu.live.lottie.model.a.f bqd;
    private final com.baidu.live.lottie.model.a.f bqe;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bqf;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bqg;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.baidu.live.lottie.model.a.c cVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.f fVar2, com.baidu.live.lottie.model.a.b bVar, com.baidu.live.lottie.model.a.b bVar2) {
        this.bqb = gradientType;
        this.FH = fillType;
        this.bqc = cVar;
        this.bpX = dVar;
        this.bqd = fVar;
        this.bqe = fVar2;
        this.name = str;
        this.bqf = bVar;
        this.bqg = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType Mf() {
        return this.bqb;
    }

    public Path.FillType jp() {
        return this.FH;
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

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.g(hVar, aVar, this);
    }
}
