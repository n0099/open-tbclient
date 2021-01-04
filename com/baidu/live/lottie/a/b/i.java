package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes10.dex */
public class i extends f<PointF> {
    private final PointF EB;
    private final float[] EC;
    private PathMeasure EE;
    private h buk;

    public i(List<? extends com.baidu.live.lottie.e.a<PointF>> list) {
        super(list);
        this.EB = new PointF();
        this.EC = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.baidu.live.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        h hVar = (h) aVar;
        Path iv = hVar.iv();
        if (iv == null) {
            return aVar.HN;
        }
        if (this.buh == null || (pointF = (PointF) this.buh.c(hVar.BU, hVar.HQ.floatValue(), hVar.HN, hVar.HO, iI(), f, getProgress())) == null) {
            if (this.buk != hVar) {
                this.EE = new PathMeasure(iv, false);
                this.buk = hVar;
            }
            this.EE.getPosTan(this.EE.getLength() * f, this.EC, null);
            this.EB.set(this.EC[0], this.EC[1]);
            return this.EB;
        }
        return pointF;
    }
}
