package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes3.dex */
public class b extends f<Integer> {
    public b(List<com.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.HL == null || aVar.HM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.HL.intValue();
        int intValue2 = aVar.HM.intValue();
        return (this.Et == null || (num = (Integer) this.Et.c(aVar.BS, aVar.HO.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, iI(), getProgress())) == null) ? Integer.valueOf(com.airbnb.lottie.d.b.b(f, intValue, intValue2)) : num;
    }
}
