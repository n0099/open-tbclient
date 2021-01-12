package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends f<PointF> {
    private final float[] EA;
    private h EB;
    private PathMeasure EC;
    private final PointF Ez;

    public i(List<? extends com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.Ez = new PointF();
        this.EA = new float[2];
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
            return aVar.HL;
        }
        if (this.Et == null || (pointF = (PointF) this.Et.c(hVar.BS, hVar.HO.floatValue(), hVar.HL, hVar.HM, iI(), f, getProgress())) == null) {
            if (this.EB != hVar) {
                this.EC = new PathMeasure(iv, false);
                this.EB = hVar;
            }
            this.EC.getPosTan(this.EC.getLength() * f, this.EA, null);
            this.Ez.set(this.EA[0], this.EA[1]);
            return this.Ez;
        }
        return pointF;
    }
}
