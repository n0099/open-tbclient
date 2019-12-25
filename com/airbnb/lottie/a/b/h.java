package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes4.dex */
public class h extends com.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.airbnb.lottie.e eVar, com.airbnb.lottie.e.a<PointF> aVar) {
        super(eVar, aVar.kn, aVar.ko, aVar.kp, aVar.ed, aVar.kq);
        boolean z = (this.ko == 0 || this.kn == 0 || !((PointF) this.kn).equals(((PointF) this.ko).x, ((PointF) this.ko).y)) ? false : true;
        if (this.ko != 0 && !z) {
            this.path = com.airbnb.lottie.d.f.a((PointF) this.kn, (PointF) this.ko, aVar.kt, aVar.ku);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path bF() {
        return this.path;
    }
}
