package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes3.dex */
public class k extends f<com.airbnb.lottie.e.d> {
    public k(List<com.airbnb.lottie.e.a<com.airbnb.lottie.e.d>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: f */
    public com.airbnb.lottie.e.d a(com.airbnb.lottie.e.a<com.airbnb.lottie.e.d> aVar, float f) {
        com.airbnb.lottie.e.d dVar;
        if (aVar.HN == null || aVar.HO == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.e.d dVar2 = aVar.HN;
        com.airbnb.lottie.e.d dVar3 = aVar.HO;
        if (this.Ev != null && (dVar = (com.airbnb.lottie.e.d) this.Ev.c(aVar.BU, aVar.HQ.floatValue(), dVar2, dVar3, f, iI(), getProgress())) != null) {
            return dVar;
        }
        return new com.airbnb.lottie.e.d(com.airbnb.lottie.d.e.lerp(dVar2.getScaleX(), dVar3.getScaleX(), f), com.airbnb.lottie.d.e.lerp(dVar2.getScaleY(), dVar3.getScaleY(), f));
    }
}
