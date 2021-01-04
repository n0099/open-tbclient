package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes10.dex */
public class l extends a<com.baidu.live.lottie.model.content.h, Path> {
    private final Path EG;
    private final com.baidu.live.lottie.model.content.h bul;

    public l(List<com.baidu.live.lottie.e.a<com.baidu.live.lottie.model.content.h>> list) {
        super(list);
        this.bul = new com.baidu.live.lottie.model.content.h();
        this.EG = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.baidu.live.lottie.e.a<com.baidu.live.lottie.model.content.h> aVar, float f) {
        this.bul.a(aVar.HN, aVar.HO, f);
        com.baidu.live.lottie.d.e.a(this.bul, this.EG);
        return this.EG;
    }
}
