package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class h extends com.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.airbnb.lottie.e eVar, com.airbnb.lottie.e.a<PointF> aVar) {
        super(eVar, aVar.km, aVar.kn, aVar.ko, aVar.ec, aVar.kp);
        boolean z = (this.kn == 0 || this.km == 0 || !((PointF) this.km).equals(((PointF) this.kn).x, ((PointF) this.kn).y)) ? false : true;
        if (this.kn != 0 && !z) {
            this.path = com.airbnb.lottie.d.f.a((PointF) this.km, (PointF) this.kn, aVar.ks, aVar.kt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path bF() {
        return this.path;
    }
}
