package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final GradientType DE;
    private final Path.FillType DG;
    private final com.airbnb.lottie.model.a.c DH;
    private final com.airbnb.lottie.model.a.f DI;
    private final com.airbnb.lottie.model.a.f DJ;
    @Nullable
    private final com.airbnb.lottie.model.a.b DK;
    @Nullable
    private final com.airbnb.lottie.model.a.b DM;
    private final com.airbnb.lottie.model.a.d Dx;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.DE = gradientType;
        this.DG = fillType;
        this.DH = cVar;
        this.Dx = dVar;
        this.DI = fVar;
        this.DJ = fVar2;
        this.name = str;
        this.DK = bVar;
        this.DM = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType hW() {
        return this.DE;
    }

    public Path.FillType hX() {
        return this.DG;
    }

    public com.airbnb.lottie.model.a.c hY() {
        return this.DH;
    }

    public com.airbnb.lottie.model.a.d hQ() {
        return this.Dx;
    }

    public com.airbnb.lottie.model.a.f hZ() {
        return this.DI;
    }

    public com.airbnb.lottie.model.a.f ia() {
        return this.DJ;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
