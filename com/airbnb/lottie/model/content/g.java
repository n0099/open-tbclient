package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b Ed;
    private final com.airbnb.lottie.model.a.b Ee;
    private final l Ef;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.Ed = bVar;
        this.Ee = bVar2;
        this.Ef = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b it() {
        return this.Ed;
    }

    public com.airbnb.lottie.model.a.b iu() {
        return this.Ee;
    }

    public l iv() {
        return this.Ef;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
