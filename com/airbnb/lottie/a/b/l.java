package com.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes20.dex */
public class l extends a<com.airbnb.lottie.model.content.h, Path> {
    private final com.airbnb.lottie.model.content.h Db;
    private final Path Dc;

    public l(List<com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.Db = new com.airbnb.lottie.model.content.h();
        this.Dc = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.h> aVar, float f) {
        this.Db.a(aVar.Gp, aVar.Gq, f);
        com.airbnb.lottie.d.e.a(this.Db, this.Dc);
        return this.Dc;
    }
}
