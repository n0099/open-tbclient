package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d EG;
    private final GradientType EM;
    private final Path.FillType EN;
    private final com.airbnb.lottie.model.a.c EO;
    private final com.airbnb.lottie.model.a.f EP;
    private final com.airbnb.lottie.model.a.f ER;
    @Nullable
    private final com.airbnb.lottie.model.a.b ES;
    @Nullable
    private final com.airbnb.lottie.model.a.b ET;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.EM = gradientType;
        this.EN = fillType;
        this.EO = cVar;
        this.EG = dVar;
        this.EP = fVar;
        this.ER = fVar2;
        this.name = str;
        this.ES = bVar;
        this.ET = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jO() {
        return this.EM;
    }

    public Path.FillType jP() {
        return this.EN;
    }

    public com.airbnb.lottie.model.a.c jQ() {
        return this.EO;
    }

    public com.airbnb.lottie.model.a.d jI() {
        return this.EG;
    }

    public com.airbnb.lottie.model.a.f jR() {
        return this.EP;
    }

    public com.airbnb.lottie.model.a.f jS() {
        return this.ER;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
