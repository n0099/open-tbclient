package com.baidu.live.lottie.a.b;

import java.util.Collections;
/* loaded from: classes10.dex */
public class p<K, A> extends a<K, A> {
    private final com.baidu.live.lottie.e.b<A> bti;

    public p(com.baidu.live.lottie.e.c<A> cVar) {
        super(Collections.emptyList());
        this.bti = new com.baidu.live.lottie.e.b<>();
        a(cVar);
    }

    @Override // com.baidu.live.lottie.a.b.a
    float iK() {
        return 1.0f;
    }

    @Override // com.baidu.live.lottie.a.b.a
    public void im() {
        if (this.bsU != null) {
            super.im();
        }
    }

    @Override // com.baidu.live.lottie.a.b.a
    public A getValue() {
        return this.bsU.c(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.baidu.live.lottie.a.b.a
    A a(com.baidu.live.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
