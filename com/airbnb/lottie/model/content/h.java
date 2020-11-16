package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class h {
    private final List<com.airbnb.lottie.model.a> FD = new ArrayList();
    private PointF FE;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.airbnb.lottie.model.a> list) {
        this.FE = pointF;
        this.closed = z;
        this.FD.addAll(list);
    }

    public h() {
    }

    private void h(float f, float f2) {
        if (this.FE == null) {
            this.FE = new PointF();
        }
        this.FE.set(f, f2);
    }

    public PointF kn() {
        return this.FE;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.airbnb.lottie.model.a> ko() {
        return this.FD;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.FE == null) {
            this.FE = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.ko().size() != hVar2.ko().size()) {
            com.airbnb.lottie.d.warn("Curves must have the same number of control points. Shape 1: " + hVar.ko().size() + "\tShape 2: " + hVar2.ko().size());
        }
        if (this.FD.isEmpty()) {
            int min = Math.min(hVar.ko().size(), hVar2.ko().size());
            for (int i = 0; i < min; i++) {
                this.FD.add(new com.airbnb.lottie.model.a());
            }
        }
        PointF kn = hVar.kn();
        PointF kn2 = hVar2.kn();
        h(com.airbnb.lottie.d.e.lerp(kn.x, kn2.x, f), com.airbnb.lottie.d.e.lerp(kn.y, kn2.y, f));
        if (this.FD.size() <= hVar.ko().size() && this.FD.size() <= hVar2.ko().size()) {
            for (int size = this.FD.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.model.a aVar = hVar.ko().get(size);
                com.airbnb.lottie.model.a aVar2 = hVar2.ko().get(size);
                PointF ju = aVar.ju();
                PointF jv = aVar.jv();
                PointF jw = aVar.jw();
                PointF ju2 = aVar2.ju();
                PointF jv2 = aVar2.jv();
                PointF jw2 = aVar2.jw();
                this.FD.get(size).e(com.airbnb.lottie.d.e.lerp(ju.x, ju2.x, f), com.airbnb.lottie.d.e.lerp(ju.y, ju2.y, f));
                this.FD.get(size).f(com.airbnb.lottie.d.e.lerp(jv.x, jv2.x, f), com.airbnb.lottie.d.e.lerp(jv.y, jv2.y, f));
                this.FD.get(size).g(com.airbnb.lottie.d.e.lerp(jw.x, jw2.x, f), com.airbnb.lottie.d.e.lerp(jw.y, jw2.y, f));
            }
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.FD.size() + "closed=" + this.closed + '}';
    }
}
