package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes18.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.d EG;
    private final Path.FillType EN;
    @Nullable
    private final com.airbnb.lottie.model.a.a Ex;
    private final boolean Fo;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Fo = z;
        this.EN = fillType;
        this.Ex = aVar;
        this.EG = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a kn() {
        return this.Ex;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d jH() {
        return this.EG;
    }

    public Path.FillType jO() {
        return this.EN;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Fo + '}';
    }
}
