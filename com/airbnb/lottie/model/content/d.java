package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes7.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d FO;
    private final GradientType FW;
    private final Path.FillType FX;
    private final com.airbnb.lottie.model.a.c FY;
    private final com.airbnb.lottie.model.a.f FZ;
    private final com.airbnb.lottie.model.a.f Ga;
    @Nullable
    private final com.airbnb.lottie.model.a.b Gb;
    @Nullable
    private final com.airbnb.lottie.model.a.b Gc;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.FW = gradientType;
        this.FX = fillType;
        this.FY = cVar;
        this.FO = dVar;
        this.FZ = fVar;
        this.Ga = fVar2;
        this.name = str;
        this.Gb = bVar;
        this.Gc = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jP() {
        return this.FW;
    }

    public Path.FillType jQ() {
        return this.FX;
    }

    public com.airbnb.lottie.model.a.c jR() {
        return this.FY;
    }

    public com.airbnb.lottie.model.a.d jJ() {
        return this.FO;
    }

    public com.airbnb.lottie.model.a.f jS() {
        return this.FZ;
    }

    public com.airbnb.lottie.model.a.f jT() {
        return this.Ga;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
