package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes16.dex */
public class h extends com.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.airbnb.lottie.e eVar, com.airbnb.lottie.e.a<PointF> aVar) {
        super(eVar, aVar.Hn, aVar.Ho, aVar.Hp, aVar.Bo, aVar.Hq);
        boolean z = (this.Ho == 0 || this.Hn == 0 || !((PointF) this.Hn).equals(((PointF) this.Ho).x, ((PointF) this.Ho).y)) ? false : true;
        if (this.Ho != 0 && !z) {
            this.path = com.airbnb.lottie.d.f.a((PointF) this.Hn, (PointF) this.Ho, aVar.Ht, aVar.Hu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path iW() {
        return this.path;
    }
}
