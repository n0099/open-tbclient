package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes10.dex */
public class a implements TypeEvaluator<C0173a> {
    private C0173a aZu = new C0173a();
    private float aZv;
    private float aZw;

    public a() {
        this.aZu.l(1.0f, 1.0f);
        this.aZv = 0.05882353f;
        this.aZw = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0173a evaluate(float f, C0173a c0173a, C0173a c0173a2) {
        if (f <= this.aZv) {
            this.aZu.l(f / this.aZv, f / this.aZv);
        } else if (f <= this.aZw) {
            this.aZu.l(1.0f, 1.0f);
        } else {
            this.aZu.l(1.0f - ((f - this.aZw) / (1.0f - this.aZw)), 1.0f - ((f - this.aZw) / (1.0f - this.aZw)));
        }
        return this.aZu;
    }

    /* renamed from: com.baidu.live.gift.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0173a {
        public float aZx;
        public float scale;

        public void l(float f, float f2) {
            this.scale = f;
            this.aZx = f2;
        }
    }
}
