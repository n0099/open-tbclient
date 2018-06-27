package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends f<PointF> {
    private final PointF mz;

    public j(List<com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.mz = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        if (aVar.lf == null || aVar.lg == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = aVar.lf;
        PointF pointF2 = aVar.lg;
        this.mz.set(pointF.x + ((pointF2.x - pointF.x) * f), ((pointF2.y - pointF.y) * f) + pointF.y);
        return this.mz;
    }
}
