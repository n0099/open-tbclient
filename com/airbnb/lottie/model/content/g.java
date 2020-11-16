package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes16.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b FA;
    private final com.airbnb.lottie.model.a.b FB;
    private final l FC;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.FA = bVar;
        this.FB = bVar2;
        this.FC = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b kk() {
        return this.FA;
    }

    public com.airbnb.lottie.model.a.b kl() {
        return this.FB;
    }

    public l km() {
        return this.FC;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
