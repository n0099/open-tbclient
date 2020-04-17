package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    private final Path.FillType DC;
    @Nullable
    private final com.airbnb.lottie.model.a.a Dm;
    @Nullable
    private final com.airbnb.lottie.model.a.d Du;
    private final boolean Ef;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Ef = z;
        this.DC = fillType;
        this.Dm = aVar;
        this.Du = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a iy() {
        return this.Dm;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d hQ() {
        return this.Du;
    }

    public Path.FillType hX() {
        return this.DC;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Ef + '}';
    }
}
