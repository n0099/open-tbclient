package com.baidu.live.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class i implements b {
    private final Path.FillType FJ;
    private final boolean Gk;
    @Nullable
    private final com.baidu.live.lottie.model.a.a buD;
    @Nullable
    private final com.baidu.live.lottie.model.a.d buL;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.baidu.live.lottie.model.a.a aVar, @Nullable com.baidu.live.lottie.model.a.d dVar) {
        this.name = str;
        this.Gk = z;
        this.FJ = fillType;
        this.buD = aVar;
        this.buL = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.a Qv() {
        return this.buD;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.d PV() {
        return this.buL;
    }

    public Path.FillType jp() {
        return this.FJ;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.f(hVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Gk + '}';
    }
}
