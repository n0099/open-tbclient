package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.a hG;
    @Nullable
    private final com.airbnb.lottie.model.a.d hO;
    private final Path.FillType hV;
    private final boolean iG;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.iG = z;
        this.hV = fillType;
        this.hG = aVar;
        this.hO = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a cY() {
        return this.hG;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d cs() {
        return this.hO;
    }

    public Path.FillType cz() {
        return this.hV;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.iG + '}';
    }
}
