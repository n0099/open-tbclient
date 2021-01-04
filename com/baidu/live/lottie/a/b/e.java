package com.baidu.live.lottie.a.b;

import java.util.List;
/* loaded from: classes10.dex */
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
        if (aVar.HN == null || aVar.HO == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.buh == null || (num = (Integer) this.buh.c(aVar.BU, aVar.HQ.floatValue(), aVar.HN, aVar.HO, f, iI(), getProgress())) == null) ? Integer.valueOf(com.baidu.live.lottie.d.e.lerp(aVar.HN.intValue(), aVar.HO.intValue(), f)) : num;
    }
}
