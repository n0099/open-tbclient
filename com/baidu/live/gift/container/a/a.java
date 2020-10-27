package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class a implements TypeEvaluator<C0183a> {
    private C0183a aZx = new C0183a();
    private float aZy;
    private float aZz;

    public a() {
        this.aZx.k(1.0f, 1.0f);
        this.aZy = 0.05882353f;
        this.aZz = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0183a evaluate(float f, C0183a c0183a, C0183a c0183a2) {
        if (f <= this.aZy) {
            this.aZx.k(f / this.aZy, f / this.aZy);
        } else if (f <= this.aZz) {
            this.aZx.k(1.0f, 1.0f);
        } else {
            this.aZx.k(1.0f - ((f - this.aZz) / (1.0f - this.aZz)), 1.0f - ((f - this.aZz) / (1.0f - this.aZz)));
        }
        return this.aZx;
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
