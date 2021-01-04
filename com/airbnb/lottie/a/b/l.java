package com.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes3.dex */
public class l extends a<com.airbnb.lottie.model.content.h, Path> {
    private final com.airbnb.lottie.model.content.h EF;
    private final Path EG;

    public l(List<com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.EF = new com.airbnb.lottie.model.content.h();
        this.EG = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h> aVar, float f) {
        this.EF.a(aVar.HN, aVar.HO, f);
        com.airbnb.lottie.d.e.a(this.EF, this.EG);
        return this.EG;
    }
}
