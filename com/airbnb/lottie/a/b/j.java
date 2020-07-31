package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes20.dex */
public class j extends f<PointF> {
    private final PointF CX;

    public j(List<com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.CX = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.Gp == null || aVar.Gq == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.Gp;
        PointF pointF3 = aVar.Gq;
        if (this.CN == null || (pointF = (PointF) this.CN.b(aVar.Aq, aVar.Gs.floatValue(), pointF2, pointF3, f, hG(), getProgress())) == null) {
            this.CX.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.CX;
        }
        return pointF;
    }
}
