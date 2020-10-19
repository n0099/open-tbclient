package com.airbnb.lottie.a.b;

import java.util.Collections;
/* loaded from: classes10.dex */
public class p<K, A> extends a<K, A> {
    private final com.airbnb.lottie.e.b<A> El;

    public p(com.airbnb.lottie.e.c<A> cVar) {
        super(Collections.emptyList());
        this.El = new com.airbnb.lottie.e.b<>();
        a(cVar);
    }

    @Override // com.airbnb.lottie.a.b.a
    float jm() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void iP() {
        if (this.DQ != null) {
            super.iP();
        }
    }

    @Override // com.airbnb.lottie.a.b.a
    public A getValue() {
        return this.DQ.b(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.airbnb.lottie.a.b.a
    A a(com.airbnb.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
