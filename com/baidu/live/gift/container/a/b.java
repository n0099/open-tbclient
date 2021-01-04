package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes11.dex */
public class b implements TypeEvaluator<Float> {
    private float bek = 0.5f;
    private float bel = 0.6666667f;
    private float ben = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.bek) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.bel) {
            return Float.valueOf((((f - this.bek) / (this.bel - this.bek)) * 0.2f) + 0.8f);
        }
        if (f <= this.ben) {
            return Float.valueOf(1.0f - (((f - this.bel) / (this.ben - this.bel)) * 0.2f));
        }
        return Float.valueOf((((f - this.ben) / (1.0f - this.ben)) * 0.2f) + 0.8f);
    }
}
