package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes9.dex */
public class l extends a<com.baidu.live.lottie.model.content.h, Path> {
    private final Path FY;
    private final com.baidu.live.lottie.model.content.h buA;

    public l(List<com.baidu.live.lottie.e.a<com.baidu.live.lottie.model.content.h>> list) {
        super(list);
        this.buA = new com.baidu.live.lottie.model.content.h();
        this.FY = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.baidu.live.lottie.e.a<com.baidu.live.lottie.model.content.h> aVar, float f) {
        this.buA.a(aVar.Jk, aVar.Jl, f);
        com.baidu.live.lottie.d.e.a(this.buA, this.FY);
        return this.FY;
    }
}
