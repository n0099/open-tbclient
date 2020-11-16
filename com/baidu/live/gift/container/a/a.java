package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class a implements TypeEvaluator<C0183a> {
    private C0183a aZe = new C0183a();
    private float aZf;
    private float aZg;

    public a() {
        this.aZe.k(1.0f, 1.0f);
        this.aZf = 0.05882353f;
        this.aZg = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0183a evaluate(float f, C0183a c0183a, C0183a c0183a2) {
        if (f <= this.aZf) {
            this.aZe.k(f / this.aZf, f / this.aZf);
        } else if (f <= this.aZg) {
            this.aZe.k(1.0f, 1.0f);
        } else {
            this.aZe.k(1.0f - ((f - this.aZg) / (1.0f - this.aZg)), 1.0f - ((f - this.aZg) / (1.0f - this.aZg)));
        }
        return this.aZe;
    }

    /* renamed from: com.baidu.live.gift.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0183a {
        public float alpha;
        public float scale;

        public void k(float f, float f2) {
            this.scale = f;
            this.alpha = f2;
        }
    }
}
