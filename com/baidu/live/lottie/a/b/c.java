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
        if (aVar.HL == null || aVar.HM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.bsU == null || (f2 = (Float) this.bsU.c(aVar.BT, aVar.HO.floatValue(), aVar.HL, aVar.HM, f, iH(), getProgress())) == null) ? Float.valueOf(com.baidu.live.lottie.d.e.lerp(aVar.HL.floatValue(), aVar.HM.floatValue(), f)) : f2;
    }
}
