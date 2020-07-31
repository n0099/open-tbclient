package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes20.dex */
public class c extends f<Float> {
    public c(List<com.airbnb.lottie.e.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: c */
    public Float a(com.airbnb.lottie.e.a<Float> aVar, float f) {
        Float f2;
        if (aVar.Gp == null || aVar.Gq == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.CN == null || (f2 = (Float) this.CN.b(aVar.Aq, aVar.Gs.floatValue(), aVar.Gp, aVar.Gq, f, hG(), getProgress())) == null) ? Float.valueOf(com.airbnb.lottie.d.e.lerp(aVar.Gp.floatValue(), aVar.Gq.floatValue(), f)) : f2;
    }
}
