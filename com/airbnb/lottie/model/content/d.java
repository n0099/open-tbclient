package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes10.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d EY;
    private final GradientType Fe;
    private final Path.FillType Ff;
    private final com.airbnb.lottie.model.a.c Fg;
    private final com.airbnb.lottie.model.a.f Fh;
    private final com.airbnb.lottie.model.a.f Fi;
    @Nullable
    private final com.airbnb.lottie.model.a.b Fj;
    @Nullable
    private final com.airbnb.lottie.model.a.b Fk;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.Fe = gradientType;
        this.Ff = fillType;
        this.Fg = cVar;
        this.EY = dVar;
        this.Fh = fVar;
        this.Fi = fVar2;
        this.name = str;
        this.Fj = bVar;
        this.Fk = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jP() {
        return this.Fe;
    }

    public Path.FillType jQ() {
        return this.Ff;
    }

    public com.airbnb.lottie.model.a.c jR() {
        return this.Fg;
    }

    public com.airbnb.lottie.model.a.d jJ() {
        return this.EY;
    }

    public com.airbnb.lottie.model.a.f jS() {
        return this.Fh;
    }

    public com.airbnb.lottie.model.a.f jT() {
        return this.Fi;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
