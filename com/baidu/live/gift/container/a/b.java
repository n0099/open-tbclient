package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class b implements TypeEvaluator<Float> {
    private float bcB = 0.5f;
    private float bcC = 0.6666667f;
    private float bcE = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.bcB) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.bcC) {
            return Float.valueOf((((f - this.bcB) / (this.bcC - this.bcB)) * 0.2f) + 0.8f);
        }
        if (f <= this.bcE) {
            return Float.valueOf(1.0f - (((f - this.bcC) / (this.bcE - this.bcC)) * 0.2f));
        }
        return Float.valueOf((((f - this.bcE) / (1.0f - this.bcE)) * 0.2f) + 0.8f);
    }
}
