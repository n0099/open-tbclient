package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes7.dex */
public class e extends f<Integer> {
    public e(List<com.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.If == null || aVar.Ig == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.EG == null || (num = (Integer) this.EG.b(aVar.Ce, aVar.Ii.floatValue(), aVar.If, aVar.Ig, f, jj(), getProgress())) == null) ? Integer.valueOf(com.airbnb.lottie.d.e.lerp(aVar.If.intValue(), aVar.Ig.intValue(), f)) : num;
    }
}
