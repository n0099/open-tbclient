package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class e extends f<Integer> {
    public e(List<com.airbnb.lottie.a.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.airbnb.lottie.a.a<Integer> aVar, float f) {
        if (aVar.dK == null || aVar.dL == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return Integer.valueOf(com.airbnb.lottie.c.e.lerp(aVar.dK.intValue(), aVar.dL.intValue(), f));
    }
}
