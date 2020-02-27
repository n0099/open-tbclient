package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d hS;
    private final GradientType hY;
    private final Path.FillType hZ;
    private final com.airbnb.lottie.model.a.c ib;
    private final com.airbnb.lottie.model.a.f ic;
    private final com.airbnb.lottie.model.a.f ie;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    private final com.airbnb.lottie.model.a.b f1if;
    @Nullable
    private final com.airbnb.lottie.model.a.b ig;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.hY = gradientType;
        this.hZ = fillType;
        this.ib = cVar;
        this.hS = dVar;
        this.ic = fVar;
        this.ie = fVar2;
        this.name = str;
        this.f1if = bVar;
        this.ig = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cz() {
        return this.hY;
    }

    public Path.FillType cA() {
        return this.hZ;
    }

    public com.airbnb.lottie.model.a.c cB() {
        return this.ib;
    }

    public com.airbnb.lottie.model.a.d ct() {
        return this.hS;
    }

    public com.airbnb.lottie.model.a.f cC() {
        return this.ic;
    }

    public com.airbnb.lottie.model.a.f cD() {
        return this.ie;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
