package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.l;
/* loaded from: classes5.dex */
public class g implements b {
    private final com.airbnb.lottie.model.a.b HA;
    private final l HB;
    private final com.airbnb.lottie.model.a.b Hz;
    private final String name;

    public g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.Hz = bVar;
        this.HA = bVar2;
        this.HB = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b jI() {
        return this.Hz;
    }

    public com.airbnb.lottie.model.a.b jJ() {
        return this.HA;
    }

    public l jK() {
        return this.HB;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
