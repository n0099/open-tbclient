package com.baidu.live.lottie.a.b;

import java.util.Collections;
/* loaded from: classes9.dex */
public class p<K, A> extends a<K, A> {
    private final com.baidu.live.lottie.e.b<A> bpH;

    public p(com.baidu.live.lottie.e.c<A> cVar) {
        super(Collections.emptyList());
        this.bpH = new com.baidu.live.lottie.e.b<>();
        a(cVar);
    }

    @Override // com.baidu.live.lottie.a.b.a
    float iL() {
        return 1.0f;
    }

    @Override // com.baidu.live.lottie.a.b.a
    public void in() {
        if (this.bpt != null) {
            super.in();
        }
    }

    @Override // com.baidu.live.lottie.a.b.a
    public A getValue() {
        return this.bpt.c(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.baidu.live.lottie.a.b.a
    A a(com.baidu.live.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
