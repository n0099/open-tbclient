package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes20.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d Eb;
    private final GradientType Eh;
    private final Path.FillType Ei;
    private final com.airbnb.lottie.model.a.c Ej;
    private final com.airbnb.lottie.model.a.f Ek;
    private final com.airbnb.lottie.model.a.f El;
    @Nullable
    private final com.airbnb.lottie.model.a.b Em;
    @Nullable
    private final com.airbnb.lottie.model.a.b En;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.Eh = gradientType;
        this.Ei = fillType;
        this.Ej = cVar;
        this.Eb = dVar;
        this.Ek = fVar;
        this.El = fVar2;
        this.name = str;
        this.Em = bVar;
        this.En = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType in() {
        return this.Eh;
    }

    public Path.FillType ip() {
        return this.Ei;
    }

    public com.airbnb.lottie.model.a.c iq() {
        return this.Ej;
    }

    public com.airbnb.lottie.model.a.d ih() {
        return this.Eb;
    }

    public com.airbnb.lottie.model.a.f ir() {
        return this.Ek;
    }

    public com.airbnb.lottie.model.a.f is() {
        return this.El;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
