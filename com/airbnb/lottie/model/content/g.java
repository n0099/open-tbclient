package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes5.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b iB;
    private final com.airbnb.lottie.model.a.b iC;
    private final l iD;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.iB = bVar;
        this.iC = bVar2;
        this.iD = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b cT() {
        return this.iB;
    }

    public com.airbnb.lottie.model.a.b cU() {
        return this.iC;
    }

    public l cV() {
        return this.iD;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
