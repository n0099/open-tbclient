package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d FB;
    private final GradientType FI;
    private final Path.FillType FJ;
    private final com.airbnb.lottie.model.a.c FK;
    private final com.airbnb.lottie.model.a.f FL;
    private final com.airbnb.lottie.model.a.f FM;
    @Nullable
    private final com.airbnb.lottie.model.a.b FN;
    @Nullable
    private final com.airbnb.lottie.model.a.b FO;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.FI = gradientType;
        this.FJ = fillType;
        this.FK = cVar;
        this.FB = dVar;
        this.FL = fVar;
        this.FM = fVar2;
        this.name = str;
        this.FN = bVar;
        this.FO = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jo() {
        return this.FI;
    }

    public Path.FillType jp() {
        return this.FJ;
    }

    public com.airbnb.lottie.model.a.c jq() {
        return this.FK;
    }

    public com.airbnb.lottie.model.a.d ji() {
        return this.FB;
    }

    public com.airbnb.lottie.model.a.f jr() {
        return this.FL;
    }

    public com.airbnb.lottie.model.a.f js() {
        return this.FM;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
