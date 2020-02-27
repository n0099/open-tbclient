package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.airbnb.lottie.e eVar, com.airbnb.lottie.e.a<PointF> aVar) {
        super(eVar, aVar.kq, aVar.kr, aVar.ks, aVar.ed, aVar.kt);
        boolean z = (this.kr == 0 || this.kq == 0 || !((PointF) this.kq).equals(((PointF) this.kr).x, ((PointF) this.kr).y)) ? false : true;
        if (this.kr != 0 && !z) {
            this.path = com.airbnb.lottie.d.f.a((PointF) this.kq, (PointF) this.kr, aVar.kx, aVar.ky);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path bG() {
        return this.path;
    }
}
