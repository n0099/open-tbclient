package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b Fj;
    private final com.airbnb.lottie.model.a.b Fk;
    private final l Fl;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.Fj = bVar;
        this.Fk = bVar2;
        this.Fl = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b kj() {
        return this.Fj;
    }

    public com.airbnb.lottie.model.a.b kk() {
        return this.Fk;
    }

    public l kl() {
        return this.Fl;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
