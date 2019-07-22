package com.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes2.dex */
public class l extends a<com.airbnb.lottie.model.content.h, Path> {
    private final com.airbnb.lottie.model.content.h nh;
    private final Path ni;

    public l(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.nh = new com.airbnb.lottie.model.content.h();
        this.ni = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h> aVar, float f) {
        this.nh.a(aVar.lI, aVar.lJ, f);
        com.airbnb.lottie.c.e.a(this.nh, this.ni);
        return this.ni;
    }
}
