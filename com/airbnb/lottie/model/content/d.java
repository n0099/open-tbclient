package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d GW;
    private final GradientType Hd;
    private final Path.FillType He;
    private final com.airbnb.lottie.model.a.c Hf;
    private final com.airbnb.lottie.model.a.f Hg;
    private final com.airbnb.lottie.model.a.f Hh;
    @Nullable
    private final com.airbnb.lottie.model.a.b Hi;
    @Nullable
    private final com.airbnb.lottie.model.a.b Hj;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.Hd = gradientType;
        this.He = fillType;
        this.Hf = cVar;
        this.GW = dVar;
        this.Hg = fVar;
        this.Hh = fVar2;
        this.name = str;
        this.Hi = bVar;
        this.Hj = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType jn() {
        return this.Hd;
    }

    public Path.FillType jo() {
        return this.He;
    }

    public com.airbnb.lottie.model.a.c jp() {
        return this.Hf;
    }

    public com.airbnb.lottie.model.a.d jh() {
        return this.GW;
    }

    public com.airbnb.lottie.model.a.f jq() {
        return this.Hg;
    }

    public com.airbnb.lottie.model.a.f jr() {
        return this.Hh;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
