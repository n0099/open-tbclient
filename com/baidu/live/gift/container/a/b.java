package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes10.dex */
public class b implements TypeEvaluator<Float> {
    private float bed = 0.5f;
    private float bee = 0.6666667f;
    private float bef = 0.8f;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        if (f <= this.bed) {
            return Float.valueOf(0.8f);
        }
        if (f <= this.bee) {
            return Float.valueOf((((f - this.bed) / (this.bee - this.bed)) * 0.2f) + 0.8f);
        }
        if (f <= this.bef) {
            return Float.valueOf(1.0f - (((f - this.bee) / (this.bef - this.bee)) * 0.2f));
        }
        return Float.valueOf((((f - this.bef) / (1.0f - this.bef)) * 0.2f) + 0.8f);
    }
}
