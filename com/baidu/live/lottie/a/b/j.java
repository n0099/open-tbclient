package com.baidu.live.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes9.dex */
public class j extends f<PointF> {
    private final PointF FT;

    public j(List<com.baidu.live.lottie.e.a<PointF>> list) {
        super(list);
        this.FT = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.baidu.live.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.Jk == null || aVar.Jl == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.Jk;
        PointF pointF3 = aVar.Jl;
        if (this.buw == null || (pointF = (PointF) this.buw.c(aVar.Dr, aVar.Jn.floatValue(), pointF2, pointF3, f, iH(), getProgress())) == null) {
            this.FT.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.FT;
        }
        return pointF;
    }
}
