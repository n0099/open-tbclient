package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes5.dex */
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
        if (aVar.km == null || aVar.kn == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.gE == null || (f2 = (Float) this.gE.b(aVar.ec, aVar.kp.floatValue(), aVar.km, aVar.kn, f, bS(), getProgress())) == null) ? Float.valueOf(com.airbnb.lottie.d.e.lerp(aVar.km.floatValue(), aVar.kn.floatValue(), f)) : f2;
    }
}
