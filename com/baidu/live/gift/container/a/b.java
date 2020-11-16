package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class b implements TypeEvaluator<Float> {
    private float aZf = 0.5f;
    private float aZg = 0.6666667f;
    private float aZh = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.aZf) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.aZg) {
            return Float.valueOf((((f - this.aZf) / (this.aZg - this.aZf)) * 0.2f) + 0.8f);
        }
        if (f <= this.aZh) {
            return Float.valueOf(1.0f - (((f - this.aZg) / (this.aZh - this.aZg)) * 0.2f));
        }
        return Float.valueOf((((f - this.aZh) / (1.0f - this.aZh)) * 0.2f) + 0.8f);
    }
}
