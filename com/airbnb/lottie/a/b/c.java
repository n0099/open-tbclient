package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes7.dex */
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
        if (aVar.If == null || aVar.Ig == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.EG == null || (f2 = (Float) this.EG.b(aVar.Ce, aVar.Ii.floatValue(), aVar.If, aVar.Ig, f, jj(), getProgress())) == null) ? Float.valueOf(com.airbnb.lottie.d.e.lerp(aVar.If.floatValue(), aVar.Ig.floatValue(), f)) : f2;
    }
}
