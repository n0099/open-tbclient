package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes4.dex */
public class e extends f<Integer> {
    public e(List<com.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.HL == null || aVar.HM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.Et == null || (num = (Integer) this.Et.c(aVar.BT, aVar.HO.floatValue(), aVar.HL, aVar.HM, f, iH(), getProgress())) == null) ? Integer.valueOf(com.airbnb.lottie.d.e.lerp(aVar.HL.intValue(), aVar.HM.intValue(), f)) : num;
    }
}
