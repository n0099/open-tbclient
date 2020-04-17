package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final GradientType DA;
    private final Path.FillType DC;
    private final com.airbnb.lottie.model.a.c DD;
    private final com.airbnb.lottie.model.a.f DE;
    private final com.airbnb.lottie.model.a.f DG;
    @Nullable
    private final com.airbnb.lottie.model.a.b DH;
    @Nullable
    private final com.airbnb.lottie.model.a.b DI;
    private final com.airbnb.lottie.model.a.d Du;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.DA = gradientType;
        this.DC = fillType;
        this.DD = cVar;
        this.Du = dVar;
        this.DE = fVar;
        this.DG = fVar2;
        this.name = str;
        this.DH = bVar;
        this.DI = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType hW() {
        return this.DA;
    }

    public Path.FillType hX() {
        return this.DC;
    }

    public com.airbnb.lottie.model.a.c hY() {
        return this.DD;
    }

    public com.airbnb.lottie.model.a.d hQ() {
        return this.Du;
    }

    public com.airbnb.lottie.model.a.f hZ() {
        return this.DE;
    }

    public com.airbnb.lottie.model.a.f ia() {
        return this.DG;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
