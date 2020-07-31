package com.airbnb.lottie.a.b;

import java.util.Collections;
/* loaded from: classes20.dex */
public class p<K, A> extends a<K, A> {
    private final com.airbnb.lottie.e.b<A> Dm;

    public p(com.airbnb.lottie.e.c<A> cVar) {
        super(Collections.emptyList());
        this.Dm = new com.airbnb.lottie.e.b<>();
        a(cVar);
    }

    @Override // com.airbnb.lottie.a.b.a
    float hJ() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void hm() {
        if (this.CN != null) {
            super.hm();
        }
    }

    @Override // com.airbnb.lottie.a.b.a
    public A getValue() {
        return this.CN.b(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.airbnb.lottie.a.b.a
    A a(com.airbnb.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
