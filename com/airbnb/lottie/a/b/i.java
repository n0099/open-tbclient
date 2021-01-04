package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends f<PointF> {
    private final PointF EB;
    private final float[] EC;
    private h ED;
    private PathMeasure EE;

    public i(List<? extends com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.EB = new PointF();
        this.EC = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        h hVar = (h) aVar;
        Path iv = hVar.iv();
        if (iv == null) {
            return aVar.HN;
        }
        if (this.Ev == null || (pointF = (PointF) this.Ev.c(hVar.BU, hVar.HQ.floatValue(), hVar.HN, hVar.HO, iI(), f, getProgress())) == null) {
            if (this.ED != hVar) {
                this.EE = new PathMeasure(iv, false);
                this.ED = hVar;
            }
            this.EE.getPosTan(this.EE.getLength() * f, this.EC, null);
            this.EB.set(this.EC[0], this.EC[1]);
            return this.EB;
        }
        return pointF;
    }
}
