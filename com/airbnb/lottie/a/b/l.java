package com.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes18.dex */
public class l extends a<com.airbnb.lottie.model.content.h, Path> {
    private final com.airbnb.lottie.model.content.h DH;
    private final Path DI;

    public l(List<com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.DH = new com.airbnb.lottie.model.content.h();
        this.DI = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h> aVar, float f) {
        this.DH.a(aVar.GX, aVar.GY, f);
        com.airbnb.lottie.d.e.a(this.DH, this.DI);
        return this.DI;
    }
}
