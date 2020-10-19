package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class b implements TypeEvaluator<Float> {
    private float aYd = 0.5f;
    private float aYe = 0.6666667f;
    private float aYf = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.aYd) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.aYe) {
            return Float.valueOf((((f - this.aYd) / (this.aYe - this.aYd)) * 0.2f) + 0.8f);
        }
        if (f <= this.aYf) {
            return Float.valueOf(1.0f - (((f - this.aYe) / (this.aYf - this.aYe)) * 0.2f));
        }
        return Float.valueOf((((f - this.aYf) / (1.0f - this.aYf)) * 0.2f) + 0.8f);
    }
}
