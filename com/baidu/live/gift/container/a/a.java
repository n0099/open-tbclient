package com.baidu.live.gift.container.a;

import android.animation.TypeEvaluator;
/* loaded from: classes4.dex */
public class a implements TypeEvaluator<C0175a> {
    private C0175a aUR = new C0175a();
    private float aUS;
    private float aUT;

    public a() {
        this.aUR.k(1.0f, 1.0f);
        this.aUS = 0.05882353f;
        this.aUT = 0.90588236f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public C0175a evaluate(float f, C0175a c0175a, C0175a c0175a2) {
        if (f <= this.aUS) {
            this.aUR.k(f / this.aUS, f / this.aUS);
        } else if (f <= this.aUT) {
            this.aUR.k(1.0f, 1.0f);
        } else {
            this.aUR.k(1.0f - ((f - this.aUT) / (1.0f - this.aUT)), 1.0f - ((f - this.aUT) / (1.0f - this.aUT)));
        }
        return this.aUR;
    }

    /* renamed from: com.baidu.live.gift.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0175a {
        public float alpha;
        public float scale;

        public void k(float f, float f2) {
            this.scale = f;
            this.alpha = f2;
        }
    }
}
