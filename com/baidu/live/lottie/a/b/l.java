package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes10.dex */
public class l extends a<com.baidu.live.lottie.model.content.h, Path> {
    private final Path EE;
    private final com.baidu.live.lottie.model.content.h bsY;

    public l(List<com.baidu.live.lottie.e.a<com.baidu.live.lottie.model.content.h>> list) {
        super(list);
        this.bsY = new com.baidu.live.lottie.model.content.h();
        this.EE = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.baidu.live.lottie.e.a<com.baidu.live.lottie.model.content.h> aVar, float f) {
        this.bsY.a(aVar.HL, aVar.HM, f);
        com.baidu.live.lottie.d.e.a(this.bsY, this.EE);
        return this.EE;
    }
}
