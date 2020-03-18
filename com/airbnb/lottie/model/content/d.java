package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d hR;
    private final GradientType hX;
    private final Path.FillType hY;
    private final com.airbnb.lottie.model.a.c hZ;
    private final com.airbnb.lottie.model.a.f ib;
    private final com.airbnb.lottie.model.a.f ic;
    @Nullable
    private final com.airbnb.lottie.model.a.b ie;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    private final com.airbnb.lottie.model.a.b f1if;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.hX = gradientType;
        this.hY = fillType;
        this.hZ = cVar;
        this.hR = dVar;
        this.ib = fVar;
        this.ic = fVar2;
        this.name = str;
        this.ie = bVar;
        this.f1if = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cz() {
        return this.hX;
    }

    public Path.FillType cA() {
        return this.hY;
    }

    public com.airbnb.lottie.model.a.c cB() {
        return this.hZ;
    }

    public com.airbnb.lottie.model.a.d ct() {
        return this.hR;
    }

    public com.airbnb.lottie.model.a.f cC() {
        return this.ib;
    }

    public com.airbnb.lottie.model.a.f cD() {
        return this.ic;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
