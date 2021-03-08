package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes10.dex */
public class a implements TypeEvaluator<C0180a> {
    private C0180a bec = new C0180a();
    private float bed;
    private float bee;

    public a() {
        this.bec.l(1.0f, 1.0f);
        this.bed = 0.05882353f;
        this.bee = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0180a evaluate(float f, C0180a c0180a, C0180a c0180a2) {
        if (f <= this.bed) {
            this.bec.l(f / this.bed, f / this.bed);
        } else if (f <= this.bee) {
            this.bec.l(1.0f, 1.0f);
        } else {
            this.bec.l(1.0f - ((f - this.bee) / (1.0f - this.bee)), 1.0f - ((f - this.bee) / (1.0f - this.bee)));
        }
        return this.bec;
    }

    /* renamed from: com.baidu.live.gift.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0180a {
        public float alpha;
        public float scale;

        public void l(float f, float f2) {
            this.scale = f;
            this.alpha = f2;
        }
    }
}
