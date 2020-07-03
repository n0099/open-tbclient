package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.a DT;
    private final boolean EJ;
    @Nullable
    private final com.airbnb.lottie.model.a.d Eb;
    private final Path.FillType Ei;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.EJ = z;
        this.Ei = fillType;
        this.DT = aVar;
        this.Eb = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a iO() {
        return this.DT;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d ih() {
        return this.Eb;
    }

    public Path.FillType ip() {
        return this.Ei;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.EJ + '}';
    }
}
