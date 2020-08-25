package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class h {
    private final List<com.airbnb.lottie.model.a> Fm = new ArrayList();
    private PointF Fn;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.airbnb.lottie.model.a> list) {
        this.Fn = pointF;
        this.closed = z;
        this.Fm.addAll(list);
    }

    public h() {
    }

    private void h(float f, float f2) {
        if (this.Fn == null) {
            this.Fn = new PointF();
        }
        this.Fn.set(f, f2);
    }

    public PointF kl() {
        return this.Fn;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.airbnb.lottie.model.a> km() {
        return this.Fm;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.Fn == null) {
            this.Fn = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.km().size() != hVar2.km().size()) {
            com.airbnb.lottie.d.warn("Curves must have the same number of control points. Shape 1: " + hVar.km().size() + "\tShape 2: " + hVar2.km().size());
        }
        if (this.Fm.isEmpty()) {
            int min = Math.min(hVar.km().size(), hVar2.km().size());
            for (int i = 0; i < min; i++) {
                this.Fm.add(new com.airbnb.lottie.model.a());
            }
        }
        PointF kl = hVar.kl();
        PointF kl2 = hVar2.kl();
        h(com.airbnb.lottie.d.e.lerp(kl.x, kl2.x, f), com.airbnb.lottie.d.e.lerp(kl.y, kl2.y, f));
        if (this.Fm.size() <= hVar.km().size() && this.Fm.size() <= hVar2.km().size()) {
            for (int size = this.Fm.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.model.a aVar = hVar.km().get(size);
                com.airbnb.lottie.model.a aVar2 = hVar2.km().get(size);
                PointF js = aVar.js();
                PointF jt = aVar.jt();
                PointF ju = aVar.ju();
                PointF js2 = aVar2.js();
                PointF jt2 = aVar2.jt();
                PointF ju2 = aVar2.ju();
                this.Fm.get(size).e(com.airbnb.lottie.d.e.lerp(js.x, js2.x, f), com.airbnb.lottie.d.e.lerp(js.y, js2.y, f));
                this.Fm.get(size).f(com.airbnb.lottie.d.e.lerp(jt.x, jt2.x, f), com.airbnb.lottie.d.e.lerp(jt.y, jt2.y, f));
                this.Fm.get(size).g(com.airbnb.lottie.d.e.lerp(ju.x, ju2.x, f), com.airbnb.lottie.d.e.lerp(ju.y, ju2.y, f));
            }
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.Fm.size() + "closed=" + this.closed + '}';
    }
}
