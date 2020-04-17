package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b Ea;
    private final com.airbnb.lottie.model.a.b Eb;
    private final l Ec;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.Ea = bVar;
        this.Eb = bVar2;
        this.Ec = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b it() {
        return this.Ea;
    }

    public com.airbnb.lottie.model.a.b iu() {
        return this.Eb;
    }

    public l iv() {
        return this.Ec;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
