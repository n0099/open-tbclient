package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class c extends f<Float> {
    public c(List<com.airbnb.lottie.a.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: c */
    public Float a(com.airbnb.lottie.a.a<Float> aVar, float f) {
        if (aVar.lJ == null || aVar.lK == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return Float.valueOf(com.airbnb.lottie.c.e.lerp(aVar.lJ.floatValue(), aVar.lK.floatValue(), f));
    }
}
