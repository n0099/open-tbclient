package com.baidu.live.lottie.a.b;

import java.util.List;
/* loaded from: classes10.dex */
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
        if (aVar.HN == null || aVar.HO == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.buh == null || (f2 = (Float) this.buh.c(aVar.BU, aVar.HQ.floatValue(), aVar.HN, aVar.HO, f, iI(), getProgress())) == null) ? Float.valueOf(com.baidu.live.lottie.d.e.lerp(aVar.HN.floatValue(), aVar.HO.floatValue(), f)) : f2;
    }
}
