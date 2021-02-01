package com.baidu.live.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class i implements b {
    private final Path.FillType FH;
    private final boolean Gi;
    @Nullable
    private final com.baidu.live.lottie.model.a.a btr;
    @Nullable
    private final com.baidu.live.lottie.model.a.d btz;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.baidu.live.lottie.model.a.a aVar, @Nullable com.baidu.live.lottie.model.a.d dVar) {
        this.name = str;
        this.Gi = z;
        this.FH = fillType;
        this.btr = aVar;
        this.btz = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.a NY() {
        return this.btr;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.d Ny() {
        return this.btz;
    }

    public Path.FillType jo() {
        return this.FH;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.f(hVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Gi + '}';
    }
}
