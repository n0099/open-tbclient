package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends f<PointF> {
    private final PointF gN;

    public j(List<com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.gN = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.kp == null || aVar.kq == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.kp;
        PointF pointF3 = aVar.kq;
        if (this.gH == null || (pointF = (PointF) this.gH.b(aVar.ec, aVar.ks.floatValue(), pointF2, pointF3, f, bT(), getProgress())) == null) {
            this.gN.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.gN;
        }
        return pointF;
    }
}
