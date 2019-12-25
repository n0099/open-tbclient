package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes4.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b iC;
    private final com.airbnb.lottie.model.a.b iD;
    private final l iE;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.iC = bVar;
        this.iD = bVar2;
        this.iE = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b cT() {
        return this.iC;
    }

    public com.airbnb.lottie.model.a.b cU() {
        return this.iD;
    }

    public l cV() {
        return this.iE;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
