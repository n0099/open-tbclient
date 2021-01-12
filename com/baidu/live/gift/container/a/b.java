package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes10.dex */
public class b implements TypeEvaluator<Float> {
    private float aZv = 0.5f;
    private float aZw = 0.6666667f;
    private float aZy = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.aZv) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.aZw) {
            return Float.valueOf((((f - this.aZv) / (this.aZw - this.aZv)) * 0.2f) + 0.8f);
        }
        if (f <= this.aZy) {
            return Float.valueOf(1.0f - (((f - this.aZw) / (this.aZy - this.aZw)) * 0.2f));
        }
        return Float.valueOf((((f - this.aZy) / (1.0f - this.aZy)) * 0.2f) + 0.8f);
    }
}
