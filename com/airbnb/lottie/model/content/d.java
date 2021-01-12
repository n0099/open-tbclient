package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class d implements b {
    private final GradientType FG;
    private final Path.FillType FH;
    private final com.airbnb.lottie.model.a.c FI;
    private final com.airbnb.lottie.model.a.f FJ;
    private final com.airbnb.lottie.model.a.f FK;
    @Nullable
    private final com.airbnb.lottie.model.a.b FL;
    @Nullable
    private final com.airbnb.lottie.model.a.b FM;
    private final com.airbnb.lottie.model.a.d Fz;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.FG = gradientType;
        this.FH = fillType;
        this.FI = cVar;
        this.Fz = dVar;
        this.FJ = fVar;
        this.FK = fVar2;
        this.name = str;
        this.FL = bVar;
        this.FM = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jo() {
        return this.FG;
    }

    public Path.FillType jp() {
        return this.FH;
    }

    public com.airbnb.lottie.model.a.c jq() {
        return this.FI;
    }

    public com.airbnb.lottie.model.a.d ji() {
        return this.Fz;
    }

    public com.airbnb.lottie.model.a.f jr() {
        return this.FJ;
    }

    public com.airbnb.lottie.model.a.f js() {
        return this.FK;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
