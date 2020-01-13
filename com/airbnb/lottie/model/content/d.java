package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d hO;
    private final GradientType hU;
    private final Path.FillType hV;
    private final com.airbnb.lottie.model.a.c hW;
    private final com.airbnb.lottie.model.a.f hX;
    private final com.airbnb.lottie.model.a.f hY;
    @Nullable
    private final com.airbnb.lottie.model.a.b hZ;
    @Nullable
    private final com.airbnb.lottie.model.a.b ib;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.hU = gradientType;
        this.hV = fillType;
        this.hW = cVar;
        this.hO = dVar;
        this.hX = fVar;
        this.hY = fVar2;
        this.name = str;
        this.hZ = bVar;
        this.ib = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cy() {
        return this.hU;
    }

    public Path.FillType cz() {
        return this.hV;
    }

    public com.airbnb.lottie.model.a.c cA() {
        return this.hW;
    }

    public com.airbnb.lottie.model.a.d cs() {
        return this.hO;
    }

    public com.airbnb.lottie.model.a.f cB() {
        return this.hX;
    }

    public com.airbnb.lottie.model.a.f cC() {
        return this.hY;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
