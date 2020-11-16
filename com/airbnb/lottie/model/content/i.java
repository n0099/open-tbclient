package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes16.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.a EP;
    @Nullable
    private final com.airbnb.lottie.model.a.d EY;
    private final boolean FF;
    private final Path.FillType Ff;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.FF = z;
        this.Ff = fillType;
        this.EP = aVar;
        this.EY = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a kp() {
        return this.EP;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d jJ() {
        return this.EY;
    }

    public Path.FillType jQ() {
        return this.Ff;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.FF + '}';
    }
}
