package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes4.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b Gd;
    private final com.airbnb.lottie.model.a.b Ge;
    private final l Gf;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.Gd = bVar;
        this.Ge = bVar2;
        this.Gf = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b jI() {
        return this.Gd;
    }

    public com.airbnb.lottie.model.a.b jJ() {
        return this.Ge;
    }

    public l jK() {
        return this.Gf;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
