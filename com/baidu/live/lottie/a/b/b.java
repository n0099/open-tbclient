package com.baidu.live.lottie.a.b;

import java.util.List;
/* loaded from: classes10.dex */
public class b extends f<Integer> {
    public b(List<com.baidu.live.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.baidu.live.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.HL == null || aVar.HM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.HL.intValue();
        int intValue2 = aVar.HM.intValue();
        return (this.bsU == null || (num = (Integer) this.bsU.c(aVar.BT, aVar.HO.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, iH(), getProgress())) == null) ? Integer.valueOf(com.baidu.live.lottie.d.b.b(f, intValue, intValue2)) : num;
    }
}
