package com.baidu.live.lottie.a.b;

import java.util.List;
/* loaded from: classes9.dex */
public class e extends f<Integer> {
    public e(List<com.baidu.live.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.baidu.live.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.HL == null || aVar.HM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.bpt == null || (num = (Integer) this.bpt.c(aVar.BS, aVar.HO.floatValue(), aVar.HL, aVar.HM, f, iI(), getProgress())) == null) ? Integer.valueOf(com.baidu.live.lottie.d.e.lerp(aVar.HL.intValue(), aVar.HM.intValue(), f)) : num;
    }
}
