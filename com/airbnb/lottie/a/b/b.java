package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes4.dex */
public class b extends f<Integer> {
    public b(List<com.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.kn == null || aVar.ko == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.kn.intValue();
        int intValue2 = aVar.ko.intValue();
        return (this.gE == null || (num = (Integer) this.gE.b(aVar.ed, aVar.kq.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, bS(), getProgress())) == null) ? Integer.valueOf(com.airbnb.lottie.d.b.b(f, intValue, intValue2)) : num;
    }
}
