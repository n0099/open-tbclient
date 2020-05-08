package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    private final Path.FillType DG;
    @Nullable
    private final com.airbnb.lottie.model.a.a Dp;
    @Nullable
    private final com.airbnb.lottie.model.a.d Dx;
    private final boolean Ei;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Ei = z;
        this.DG = fillType;
        this.Dp = aVar;
        this.Dx = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a iy() {
        return this.Dp;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d hQ() {
        return this.Dx;
    }

    public Path.FillType hX() {
        return this.DG;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Ei + '}';
    }
}
