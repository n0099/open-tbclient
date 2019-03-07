package com.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes2.dex */
public class l extends a<com.airbnb.lottie.model.content.h, Path> {
    private final com.airbnb.lottie.model.content.h pJ;
    private final Path pK;

    public l(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.pJ = new com.airbnb.lottie.model.content.h();
        this.pK = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h> aVar, float f) {
        this.pJ.a(aVar.oh, aVar.oi, f);
        com.airbnb.lottie.c.e.a(this.pJ, this.pK);
        return this.pK;
    }
}
