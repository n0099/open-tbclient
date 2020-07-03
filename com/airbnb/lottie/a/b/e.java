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
        if (aVar.Gp == null || aVar.Gq == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.CK == null || (num = (Integer) this.CK.b(aVar.Ao, aVar.Gs.floatValue(), aVar.Gp, aVar.Gq, f, hG(), getProgress())) == null) ? Integer.valueOf(com.airbnb.lottie.d.e.lerp(aVar.Gp.intValue(), aVar.Gq.intValue(), f)) : num;
    }
}
