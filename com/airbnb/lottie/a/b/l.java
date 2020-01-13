package com.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes5.dex */
public class l extends a<com.airbnb.lottie.model.content.h, Path> {
    private final com.airbnb.lottie.model.content.h gO;
    private final Path gP;

    public l(List<com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.gO = new com.airbnb.lottie.model.content.h();
        this.gP = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h> aVar, float f) {
        this.gO.a(aVar.km, aVar.kn, f);
        com.airbnb.lottie.d.e.a(this.gO, this.gP);
        return this.gP;
    }
}
