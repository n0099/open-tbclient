package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b iF;
    private final com.airbnb.lottie.model.a.b iG;
    private final l iH;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.iF = bVar;
        this.iG = bVar2;
        this.iH = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b cU() {
        return this.iF;
    }

    public com.airbnb.lottie.model.a.b cV() {
        return this.iG;
    }

    public l cW() {
        return this.iH;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
