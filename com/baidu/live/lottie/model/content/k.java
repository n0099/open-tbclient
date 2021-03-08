package com.baidu.live.lottie.model.content;

import com.baidu.live.lottie.a.a.p;
/* loaded from: classes9.dex */
public class k implements b {
    private final com.baidu.live.lottie.model.a.h bvA;
    private final int index;
    private final String name;

    public k(String str, int i, com.baidu.live.lottie.model.a.h hVar) {
        this.name = str;
        this.index = i;
        this.bvA = hVar;
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.h Oc() {
        return this.bvA;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new p(hVar, aVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.name + ", index=" + this.index + '}';
    }
}
