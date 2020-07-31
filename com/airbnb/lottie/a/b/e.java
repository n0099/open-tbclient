package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes20.dex */
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
        if (aVar.Gp == null || aVar.Gq == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.CN == null || (num = (Integer) this.CN.b(aVar.Aq, aVar.Gs.floatValue(), aVar.Gp, aVar.Gq, f, hG(), getProgress())) == null) ? Integer.valueOf(com.airbnb.lottie.d.e.lerp(aVar.Gp.intValue(), aVar.Gq.intValue(), f)) : num;
    }
}
