package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class h extends com.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.airbnb.lottie.d dVar, com.airbnb.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.HL, aVar.HM, aVar.HN, aVar.BT, aVar.HO);
        boolean z = (this.HM == 0 || this.HL == 0 || !((PointF) this.HL).equals(((PointF) this.HM).x, ((PointF) this.HM).y)) ? false : true;
        if (this.HM != 0 && !z) {
            this.path = com.airbnb.lottie.d.f.b((PointF) this.HL, (PointF) this.HM, aVar.HR, aVar.HS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path iu() {
        return this.path;
    }
}
