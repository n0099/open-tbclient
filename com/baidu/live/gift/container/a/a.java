package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class a implements TypeEvaluator<C0182a> {
    private C0182a aYc = new C0182a();
    private float aYd;
    private float aYe;

    public a() {
        this.aYc.k(1.0f, 1.0f);
        this.aYd = 0.05882353f;
        this.aYe = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0182a evaluate(float f, C0182a c0182a, C0182a c0182a2) {
        if (f <= this.aYd) {
            this.aYc.k(f / this.aYd, f / this.aYd);
        } else if (f <= this.aYe) {
            this.aYc.k(1.0f, 1.0f);
        } else {
            this.aYc.k(1.0f - ((f - this.aYe) / (1.0f - this.aYe)), 1.0f - ((f - this.aYe) / (1.0f - this.aYe)));
        }
        return this.aYc;
    }

    /* renamed from: com.baidu.live.gift.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0182a {
        public float alpha;
        public float scale;

        public void k(float f, float f2) {
            this.scale = f;
            this.alpha = f2;
        }
    }
}
