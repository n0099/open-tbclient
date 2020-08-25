package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes18.dex */
public class k extends f<com.airbnb.lottie.e.d> {
    public k(List<com.airbnb.lottie.e.a<com.airbnb.lottie.e.d>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: f */
    public com.airbnb.lottie.e.d a(com.airbnb.lottie.e.a<com.airbnb.lottie.e.d> aVar, float f) {
        com.airbnb.lottie.e.d dVar;
        if (aVar.GX == null || aVar.GY == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.e.d dVar2 = aVar.GX;
        com.airbnb.lottie.e.d dVar3 = aVar.GY;
        if (this.Dv != null && (dVar = (com.airbnb.lottie.e.d) this.Dv.b(aVar.AX, aVar.Ha.floatValue(), dVar2, dVar3, f, jh(), getProgress())) != null) {
            return dVar;
        }
        return new com.airbnb.lottie.e.d(com.airbnb.lottie.d.e.lerp(dVar2.getScaleX(), dVar3.getScaleX(), f), com.airbnb.lottie.d.e.lerp(dVar2.getScaleY(), dVar3.getScaleY(), f));
    }
}
