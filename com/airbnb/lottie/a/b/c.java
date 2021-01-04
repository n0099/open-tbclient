package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes3.dex */
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
        if (aVar.HN == null || aVar.HO == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.Ev == null || (f2 = (Float) this.Ev.c(aVar.BU, aVar.HQ.floatValue(), aVar.HN, aVar.HO, f, iI(), getProgress())) == null) ? Float.valueOf(com.airbnb.lottie.d.e.lerp(aVar.HN.floatValue(), aVar.HO.floatValue(), f)) : f2;
    }
}
