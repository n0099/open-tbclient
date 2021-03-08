package com.airbnb.lottie.a.b;

import java.util.Collections;
/* loaded from: classes5.dex */
public class p<K, A> extends a<K, A> {
    private final com.airbnb.lottie.e.b<A> Gi;

    public p(com.airbnb.lottie.e.c<A> cVar) {
        super(Collections.emptyList());
        this.Gi = new com.airbnb.lottie.e.b<>();
        a(cVar);
    }

    @Override // com.airbnb.lottie.a.b.a
    float iK() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void im() {
        if (this.FM != null) {
            super.im();
        }
    }

    @Override // com.airbnb.lottie.a.b.a
    public A getValue() {
        return this.FM.c(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.airbnb.lottie.a.b.a
    A a(com.airbnb.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
