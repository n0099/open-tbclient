package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class k extends f<com.airbnb.lottie.model.k> {
    public k(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.k>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: f */
    public com.airbnb.lottie.model.k a(com.airbnb.lottie.a.a<com.airbnb.lottie.model.k> aVar, float f) {
        if (aVar.lJ == null || aVar.lK == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.model.k kVar = aVar.lJ;
        com.airbnb.lottie.model.k kVar2 = aVar.lK;
        return new com.airbnb.lottie.model.k(com.airbnb.lottie.c.e.lerp(kVar.getScaleX(), kVar2.getScaleX(), f), com.airbnb.lottie.c.e.lerp(kVar.getScaleY(), kVar2.getScaleY(), f));
    }
}
