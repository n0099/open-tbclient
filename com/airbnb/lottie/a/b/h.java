package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class h extends com.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.airbnb.lottie.d dVar, com.airbnb.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.HN, aVar.HO, aVar.HP, aVar.BU, aVar.HQ);
        boolean z = (this.HO == 0 || this.HN == 0 || !((PointF) this.HN).equals(((PointF) this.HO).x, ((PointF) this.HO).y)) ? false : true;
        if (this.HO != 0 && !z) {
            this.path = com.airbnb.lottie.d.f.b((PointF) this.HN, (PointF) this.HO, aVar.HU, aVar.HV);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path iv() {
        return this.path;
    }
}
