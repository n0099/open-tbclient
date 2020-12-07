package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes7.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b Gs;
    private final com.airbnb.lottie.model.a.b Gt;
    private final l Gu;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.Gs = bVar;
        this.Gt = bVar2;
        this.Gu = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b kk() {
        return this.Gs;
    }

    public com.airbnb.lottie.model.a.b kl() {
        return this.Gt;
    }

    public l km() {
        return this.Gu;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
