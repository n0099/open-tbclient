package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class b implements TypeEvaluator<Float> {
    private float aUS = 0.5f;
    private float aUT = 0.6666667f;
    private float aUU = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.aUS) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.aUT) {
            return Float.valueOf((((f - this.aUS) / (this.aUT - this.aUS)) * 0.2f) + 0.8f);
        }
        if (f <= this.aUU) {
            return Float.valueOf(1.0f - (((f - this.aUT) / (this.aUU - this.aUT)) * 0.2f));
        }
        return Float.valueOf((((f - this.aUU) / (1.0f - this.aUU)) * 0.2f) + 0.8f);
    }
}
