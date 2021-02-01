package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes11.dex */
public class a implements TypeEvaluator<C0174a> {
    private C0174a bcC = new C0174a();
    private float bcD;
    private float bcE;

    public a() {
        this.bcC.l(1.0f, 1.0f);
        this.bcD = 0.05882353f;
        this.bcE = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0174a evaluate(float f, C0174a c0174a, C0174a c0174a2) {
        if (f <= this.bcD) {
            this.bcC.l(f / this.bcD, f / this.bcD);
        } else if (f <= this.bcE) {
            this.bcC.l(1.0f, 1.0f);
        } else {
            this.bcC.l(1.0f - ((f - this.bcE) / (1.0f - this.bcE)), 1.0f - ((f - this.bcE) / (1.0f - this.bcE)));
        }
        return this.bcC;
    }

    /* renamed from: com.baidu.live.gift.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0174a {
        public float alpha;
        public float scale;

        public void l(float f, float f2) {
            this.scale = f;
            this.alpha = f2;
        }
    }
}
