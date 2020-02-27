package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.a hK;
    @Nullable
    private final com.airbnb.lottie.model.a.d hS;
    private final Path.FillType hZ;
    private final boolean iK;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.iK = z;
        this.hZ = fillType;
        this.hK = aVar;
        this.hS = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a cZ() {
        return this.hK;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d ct() {
        return this.hS;
    }

    public Path.FillType cA() {
        return this.hZ;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.iK + '}';
    }
}
