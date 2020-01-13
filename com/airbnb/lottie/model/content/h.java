package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {
    private boolean closed;
    private final List<com.airbnb.lottie.model.a> iE = new ArrayList();
    private PointF iF;

    public h(PointF pointF, boolean z, List<com.airbnb.lottie.model.a> list) {
        this.iF = pointF;
        this.closed = z;
        this.iE.addAll(list);
    }

    public h() {
    }

    private void i(float f, float f2) {
        if (this.iF == null) {
            this.iF = new PointF();
        }
        this.iF.set(f, f2);
    }

    public PointF cW() {
        return this.iF;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.airbnb.lottie.model.a> cX() {
        return this.iE;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.iF == null) {
            this.iF = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.cX().size() != hVar2.cX().size()) {
            com.airbnb.lottie.d.warn("Curves must have the same number of control points. Shape 1: " + hVar.cX().size() + "\tShape 2: " + hVar2.cX().size());
        }
        if (this.iE.isEmpty()) {
            int min = Math.min(hVar.cX().size(), hVar2.cX().size());
            for (int i = 0; i < min; i++) {
                this.iE.add(new com.airbnb.lottie.model.a());
            }
        }
        PointF cW = hVar.cW();
        PointF cW2 = hVar2.cW();
        i(com.airbnb.lottie.d.e.lerp(cW.x, cW2.x, f), com.airbnb.lottie.d.e.lerp(cW.y, cW2.y, f));
        for (int size = this.iE.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.model.a aVar = hVar.cX().get(size);
            com.airbnb.lottie.model.a aVar2 = hVar2.cX().get(size);
            PointF cd = aVar.cd();
            PointF ce = aVar.ce();
            PointF cf = aVar.cf();
            PointF cd2 = aVar2.cd();
            PointF ce2 = aVar2.ce();
            PointF cf2 = aVar2.cf();
            this.iE.get(size).f(com.airbnb.lottie.d.e.lerp(cd.x, cd2.x, f), com.airbnb.lottie.d.e.lerp(cd.y, cd2.y, f));
            this.iE.get(size).g(com.airbnb.lottie.d.e.lerp(ce.x, ce2.x, f), com.airbnb.lottie.d.e.lerp(ce.y, ce2.y, f));
            this.iE.get(size).h(com.airbnb.lottie.d.e.lerp(cf.x, cf2.x, f), com.airbnb.lottie.d.e.lerp(cf.y, cf2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.iE.size() + "closed=" + this.closed + '}';
    }
}
