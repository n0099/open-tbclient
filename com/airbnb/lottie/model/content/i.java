package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.d FB;
    private final Path.FillType FJ;
    @Nullable
    private final com.airbnb.lottie.model.a.a Ft;
    private final boolean Gk;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Gk = z;
        this.FJ = fillType;
        this.Ft = aVar;
        this.FB = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a jO() {
        return this.Ft;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d ji() {
        return this.FB;
    }

    public Path.FillType jp() {
        return this.FJ;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Gk + '}';
    }
}
