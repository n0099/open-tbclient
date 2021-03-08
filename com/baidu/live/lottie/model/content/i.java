package com.baidu.live.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class i implements b {
    private final boolean HE;
    private final Path.FillType He;
    @Nullable
    private final com.baidu.live.lottie.model.a.a buS;
    @Nullable
    private final com.baidu.live.lottie.model.a.d bva;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.baidu.live.lottie.model.a.a aVar, @Nullable com.baidu.live.lottie.model.a.d dVar) {
        this.name = str;
        this.HE = z;
        this.He = fillType;
        this.buS = aVar;
        this.bva = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.a Ob() {
        return this.buS;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.d NB() {
        return this.bva;
    }

    public Path.FillType jo() {
        return this.He;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.f(hVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.HE + '}';
    }
}
