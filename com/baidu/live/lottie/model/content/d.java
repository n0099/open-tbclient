package com.baidu.live.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class d implements b {
    private final Path.FillType He;
    private final com.baidu.live.lottie.model.a.d bva;
    private final GradientType bve;
    private final com.baidu.live.lottie.model.a.c bvf;
    private final com.baidu.live.lottie.model.a.f bvg;
    private final com.baidu.live.lottie.model.a.f bvh;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bvi;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bvj;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.baidu.live.lottie.model.a.c cVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.f fVar2, com.baidu.live.lottie.model.a.b bVar, com.baidu.live.lottie.model.a.b bVar2) {
        this.bve = gradientType;
        this.He = fillType;
        this.bvf = cVar;
        this.bva = dVar;
        this.bvg = fVar;
        this.bvh = fVar2;
        this.name = str;
        this.bvi = bVar;
        this.bvj = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType NG() {
        return this.bve;
    }

    public Path.FillType jo() {
        return this.He;
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

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.g(hVar, aVar, this);
    }
}
