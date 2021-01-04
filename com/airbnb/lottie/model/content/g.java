package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes3.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b Gf;
    private final com.airbnb.lottie.model.a.b Gg;
    private final l Gh;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.Gf = bVar;
        this.Gg = bVar2;
        this.Gh = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b jJ() {
        return this.Gf;
    }

    public com.airbnb.lottie.model.a.b jK() {
        return this.Gg;
    }

    public l jL() {
        return this.Gh;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
