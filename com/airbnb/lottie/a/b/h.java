package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.airbnb.lottie.e eVar, com.airbnb.lottie.e.a<PointF> aVar) {
        super(eVar, aVar.kp, aVar.kq, aVar.kr, aVar.ec, aVar.ks);
        boolean z = (this.kq == 0 || this.kp == 0 || !((PointF) this.kp).equals(((PointF) this.kq).x, ((PointF) this.kq).y)) ? false : true;
        if (this.kq != 0 && !z) {
            this.path = com.airbnb.lottie.d.f.a((PointF) this.kp, (PointF) this.kq, aVar.kv, aVar.kx);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path bG() {
        return this.path;
    }
}
