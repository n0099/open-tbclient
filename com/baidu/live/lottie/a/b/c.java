package com.baidu.live.lottie.a.b;

import java.util.List;
/* loaded from: classes9.dex */
public class c extends f<Float> {
    public c(List<com.baidu.live.lottie.e.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: c */
    public Float a(com.baidu.live.lottie.e.a<Float> aVar, float f) {
        Float f2;
        if (aVar.Jk == null || aVar.Jl == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.buw == null || (f2 = (Float) this.buw.c(aVar.Dr, aVar.Jn.floatValue(), aVar.Jk, aVar.Jl, f, iH(), getProgress())) == null) ? Float.valueOf(com.baidu.live.lottie.d.e.lerp(aVar.Jk.floatValue(), aVar.Jl.floatValue(), f)) : f2;
    }
}
