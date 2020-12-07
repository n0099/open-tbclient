package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes7.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.a FG;
    @Nullable
    private final com.airbnb.lottie.model.a.d FO;
    private final Path.FillType FX;
    private final boolean Gx;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Gx = z;
        this.FX = fillType;
        this.FG = aVar;
        this.FO = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a kp() {
        return this.FG;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d jJ() {
        return this.FO;
    }

    public Path.FillType jQ() {
        return this.FX;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Gx + '}';
    }
}
