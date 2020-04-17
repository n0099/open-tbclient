package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
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
        if (aVar.FL == null || aVar.FM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.Cj == null || (f2 = (Float) this.Cj.b(aVar.zN, aVar.FO.floatValue(), aVar.FL, aVar.FM, f, hq(), getProgress())) == null) ? Float.valueOf(com.airbnb.lottie.d.e.lerp(aVar.FL.floatValue(), aVar.FM.floatValue(), f)) : f2;
    }
}
