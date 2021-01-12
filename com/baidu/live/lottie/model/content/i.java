package com.baidu.live.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class i implements b {
    private final Path.FillType FH;
    private final boolean Gi;
    @Nullable
    private final com.baidu.live.lottie.model.a.a bpP;
    @Nullable
    private final com.baidu.live.lottie.model.a.d bpX;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.baidu.live.lottie.model.a.a aVar, @Nullable com.baidu.live.lottie.model.a.d dVar) {
        this.name = str;
        this.Gi = z;
        this.FH = fillType;
        this.bpP = aVar;
        this.bpX = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.a MA() {
        return this.bpP;
    }

    @Nullable
    public com.baidu.live.lottie.model.a.d Ma() {
        return this.bpX;
    }

    public Path.FillType jp() {
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
