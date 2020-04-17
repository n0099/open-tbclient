package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
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
        if (aVar.FL == null || aVar.FM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.Cj == null || (num = (Integer) this.Cj.b(aVar.zN, aVar.FO.floatValue(), aVar.FL, aVar.FM, f, hq(), getProgress())) == null) ? Integer.valueOf(com.airbnb.lottie.d.e.lerp(aVar.FL.intValue(), aVar.FM.intValue(), f)) : num;
    }
}
