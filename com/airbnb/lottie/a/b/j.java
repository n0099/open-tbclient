package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends f<PointF> {
    private final PointF EB;

    public j(List<com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.EB = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.HN == null || aVar.HO == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.HN;
        PointF pointF3 = aVar.HO;
        if (this.Ev == null || (pointF = (PointF) this.Ev.c(aVar.BU, aVar.HQ.floatValue(), pointF2, pointF3, f, iI(), getProgress())) == null) {
            this.EB.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.EB;
        }
        return pointF;
    }
}
