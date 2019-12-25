package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes4.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d hO;
    private final GradientType hV;
    private final Path.FillType hW;
    private final com.airbnb.lottie.model.a.c hX;
    private final com.airbnb.lottie.model.a.f hY;
    private final com.airbnb.lottie.model.a.f hZ;
    @Nullable
    private final com.airbnb.lottie.model.a.b ib;
    @Nullable
    private final com.airbnb.lottie.model.a.b ic;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.hV = gradientType;
        this.hW = fillType;
        this.hX = cVar;
        this.hO = dVar;
        this.hY = fVar;
        this.hZ = fVar2;
        this.name = str;
        this.ib = bVar;
        this.ic = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cy() {
        return this.hV;
    }

    public Path.FillType cz() {
        return this.hW;
    }

    public com.airbnb.lottie.model.a.c cA() {
        return this.hX;
    }

    public com.airbnb.lottie.model.a.d cs() {
        return this.hO;
    }

    public com.airbnb.lottie.model.a.f cB() {
        return this.hY;
    }

    public com.airbnb.lottie.model.a.f cC() {
        return this.hZ;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
