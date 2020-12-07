package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class a implements TypeEvaluator<C0188a> {
    private C0188a bcA = new C0188a();
    private float bcB;
    private float bcC;

    public a() {
        this.bcA.k(1.0f, 1.0f);
        this.bcB = 0.05882353f;
        this.bcC = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0188a evaluate(float f, C0188a c0188a, C0188a c0188a2) {
        if (f <= this.bcB) {
            this.bcA.k(f / this.bcB, f / this.bcB);
        } else if (f <= this.bcC) {
            this.bcA.k(1.0f, 1.0f);
        } else {
            this.bcA.k(1.0f - ((f - this.bcC) / (1.0f - this.bcC)), 1.0f - ((f - this.bcC) / (1.0f - this.bcC)));
        }
        return this.bcA;
    }

    /* renamed from: com.baidu.live.gift.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0188a {
        public float bcD;
        public float scale;

        public void k(float f, float f2) {
            this.scale = f;
            this.bcD = f2;
        }
    }
}
