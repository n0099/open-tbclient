package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class h extends com.baidu.live.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.baidu.live.lottie.e eVar, com.baidu.live.lottie.e.a<PointF> aVar) {
        super(eVar, aVar.HL, aVar.HM, aVar.HN, aVar.BS, aVar.HO);
        boolean z = (this.HM == 0 || this.HL == 0 || !((PointF) this.HL).equals(((PointF) this.HM).x, ((PointF) this.HM).y)) ? false : true;
        if (this.HM != 0 && !z) {
            this.path = com.baidu.live.lottie.d.f.b((PointF) this.HL, (PointF) this.HM, aVar.HR, aVar.HS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path iv() {
        return this.path;
    }
}
