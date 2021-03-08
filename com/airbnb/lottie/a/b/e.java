package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes5.dex */
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
        if (aVar.Jk == null || aVar.Jl == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.FM == null || (num = (Integer) this.FM.c(aVar.Dr, aVar.Jn.floatValue(), aVar.Jk, aVar.Jl, f, iH(), getProgress())) == null) ? Integer.valueOf(com.airbnb.lottie.d.e.lerp(aVar.Jk.intValue(), aVar.Jl.intValue(), f)) : num;
    }
}
