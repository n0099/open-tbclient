package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes5.dex */
public class b extends f<Integer> {
    public b(List<com.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.Jk == null || aVar.Jl == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.Jk.intValue();
        int intValue2 = aVar.Jl.intValue();
        return (this.FM == null || (num = (Integer) this.FM.c(aVar.Dr, aVar.Jn.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, iH(), getProgress())) == null) ? Integer.valueOf(com.airbnb.lottie.d.b.b(f, intValue, intValue2)) : num;
    }
}
