package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes11.dex */
public class b implements TypeEvaluator<Float> {
    private float bcD = 0.5f;
    private float bcE = 0.6666667f;
    private float bcF = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.bcD) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.bcE) {
            return Float.valueOf((((f - this.bcD) / (this.bcE - this.bcD)) * 0.2f) + 0.8f);
        }
        if (f <= this.bcF) {
            return Float.valueOf(1.0f - (((f - this.bcE) / (this.bcF - this.bcE)) * 0.2f));
        }
        return Float.valueOf((((f - this.bcF) / (1.0f - this.bcF)) * 0.2f) + 0.8f);
    }
}
