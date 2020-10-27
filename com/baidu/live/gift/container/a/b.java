package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class b implements TypeEvaluator<Float> {
    private float aZy = 0.5f;
    private float aZz = 0.6666667f;
    private float aZA = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.aZy) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.aZz) {
            return Float.valueOf((((f - this.aZy) / (this.aZz - this.aZy)) * 0.2f) + 0.8f);
        }
        if (f <= this.aZA) {
            return Float.valueOf(1.0f - (((f - this.aZz) / (this.aZA - this.aZz)) * 0.2f));
        }
        return Float.valueOf((((f - this.aZA) / (1.0f - this.aZA)) * 0.2f) + 0.8f);
    }
}
