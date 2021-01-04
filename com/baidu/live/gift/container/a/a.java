package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes11.dex */
public class a implements TypeEvaluator<C0182a> {
    private C0182a bej = new C0182a();
    private float bek;
    private float bel;

    public a() {
        this.bej.k(1.0f, 1.0f);
        this.bek = 0.05882353f;
        this.bel = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0182a evaluate(float f, C0182a c0182a, C0182a c0182a2) {
        if (f <= this.bek) {
            this.bej.k(f / this.bek, f / this.bek);
        } else if (f <= this.bel) {
            this.bej.k(1.0f, 1.0f);
        } else {
            this.bej.k(1.0f - ((f - this.bel) / (1.0f - this.bel)), 1.0f - ((f - this.bel) / (1.0f - this.bel)));
        }
        return this.bej;
    }

    /* renamed from: com.baidu.live.gift.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0182a {
        public float bem;
        public float scale;

        public void k(float f, float f2) {
            this.scale = f;
            this.bem = f2;
        }
    }
}
