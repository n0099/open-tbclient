package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.p;
/* loaded from: classes4.dex */
public class k implements b {
    private final com.airbnb.lottie.model.a.h iI;
    private final int index;
    private final String name;

    public k(String str, int i, com.airbnb.lottie.model.a.h hVar) {
        this.name = str;
        this.index = i;
        this.iI = hVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.h cZ() {
        return this.iI;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new p(gVar, aVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.name + ", index=" + this.index + '}';
    }
}
