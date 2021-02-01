package com.baidu.live.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes10.dex */
public class j extends f<PointF> {
    private final PointF Ez;

    public j(List<com.baidu.live.lottie.e.a<PointF>> list) {
        super(list);
        this.Ez = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.baidu.live.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.HL == null || aVar.HM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.HL;
        PointF pointF3 = aVar.HM;
        if (this.bsU == null || (pointF = (PointF) this.bsU.c(aVar.BT, aVar.HO.floatValue(), pointF2, pointF3, f, iH(), getProgress())) == null) {
            this.Ez.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.Ez;
        }
        return pointF;
    }
}
