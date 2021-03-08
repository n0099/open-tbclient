package com.baidu.live.lottie.a.b;

import java.util.List;
/* loaded from: classes9.dex */
public class k extends f<com.baidu.live.lottie.e.d> {
    public k(List<com.baidu.live.lottie.e.a<com.baidu.live.lottie.e.d>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: f */
    public com.baidu.live.lottie.e.d a(com.baidu.live.lottie.e.a<com.baidu.live.lottie.e.d> aVar, float f) {
        com.baidu.live.lottie.e.d dVar;
        if (aVar.Jk == null || aVar.Jl == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.baidu.live.lottie.e.d dVar2 = aVar.Jk;
        com.baidu.live.lottie.e.d dVar3 = aVar.Jl;
        if (this.buw != null && (dVar = (com.baidu.live.lottie.e.d) this.buw.c(aVar.Dr, aVar.Jn.floatValue(), dVar2, dVar3, f, iH(), getProgress())) != null) {
            return dVar;
        }
        return new com.baidu.live.lottie.e.d(com.baidu.live.lottie.d.e.lerp(dVar2.getScaleX(), dVar3.getScaleX(), f), com.baidu.live.lottie.d.e.lerp(dVar2.getScaleY(), dVar3.getScaleY(), f));
    }
}
