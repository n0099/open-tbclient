package com.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends a<com.airbnb.lottie.model.content.h, Path> {
    private final com.airbnb.lottie.model.content.h CZ;
    private final Path Da;

    public l(List<com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.CZ = new com.airbnb.lottie.model.content.h();
        this.Da = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h> aVar, float f) {
        this.CZ.a(aVar.Gp, aVar.Gq, f);
        com.airbnb.lottie.d.e.a(this.CZ, this.Da);
        return this.Da;
    }
}
