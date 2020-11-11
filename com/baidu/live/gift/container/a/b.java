package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class b implements TypeEvaluator<Float> {
    private float baR = 0.5f;
    private float baS = 0.6666667f;
    private float baT = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.baR) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.baS) {
            return Float.valueOf((((f - this.baR) / (this.baS - this.baR)) * 0.2f) + 0.8f);
        }
        if (f <= this.baT) {
            return Float.valueOf(1.0f - (((f - this.baS) / (this.baT - this.baS)) * 0.2f));
        }
        return Float.valueOf((((f - this.baT) / (1.0f - this.baT)) * 0.2f) + 0.8f);
    }
}
