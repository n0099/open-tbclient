package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class a implements TypeEvaluator<C0185a> {
    private C0185a baQ = new C0185a();
    private float baR;
    private float baS;

    public a() {
        this.baQ.k(1.0f, 1.0f);
        this.baR = 0.05882353f;
        this.baS = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0185a evaluate(float f, C0185a c0185a, C0185a c0185a2) {
        if (f <= this.baR) {
            this.baQ.k(f / this.baR, f / this.baR);
        } else if (f <= this.baS) {
            this.baQ.k(1.0f, 1.0f);
        } else {
            this.baQ.k(1.0f - ((f - this.baS) / (1.0f - this.baS)), 1.0f - ((f - this.baS) / (1.0f - this.baS)));
        }
        return this.baQ;
    }

    /* renamed from: com.baidu.live.gift.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0185a {
        public float alpha;
        public float scale;

        public void k(float f, float f2) {
            this.scale = f;
            this.alpha = f2;
        }
    }
}
