package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class i implements b {
    private final Path.FillType FH;
    @Nullable
    private final com.airbnb.lottie.model.a.a Fr;
    @Nullable
    private final com.airbnb.lottie.model.a.d Fz;
    private final boolean Gi;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Gi = z;
        this.FH = fillType;
        this.Fr = aVar;
        this.Fz = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a jN() {
        return this.Fr;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d jh() {
        return this.Fz;
    }

    public Path.FillType jo() {
        return this.FH;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Gi + '}';
    }
}
