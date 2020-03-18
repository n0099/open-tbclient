package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.a hJ;
    @Nullable
    private final com.airbnb.lottie.model.a.d hR;
    private final Path.FillType hY;
    private final boolean iJ;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.iJ = z;
        this.hY = fillType;
        this.hJ = aVar;
        this.hR = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a cZ() {
        return this.hJ;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d ct() {
        return this.hR;
    }

    public Path.FillType cA() {
        return this.hY;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.iJ + '}';
    }
}
