package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.a GM;
    @Nullable
    private final com.airbnb.lottie.model.a.d GW;
    private final boolean HE;
    private final Path.FillType He;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.HE = z;
        this.He = fillType;
        this.GM = aVar;
        this.GW = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a jN() {
        return this.GM;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d jh() {
        return this.GW;
    }

    public Path.FillType jo() {
        return this.He;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.HE + '}';
    }
}
