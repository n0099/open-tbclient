package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class h extends com.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.airbnb.lottie.d dVar, com.airbnb.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.Jk, aVar.Jl, aVar.Jm, aVar.Dr, aVar.Jn);
        boolean z = (this.Jl == 0 || this.Jk == 0 || !((PointF) this.Jk).equals(((PointF) this.Jl).x, ((PointF) this.Jl).y)) ? false : true;
        if (this.Jl != 0 && !z) {
            this.path = com.airbnb.lottie.d.f.b((PointF) this.Jk, (PointF) this.Jl, aVar.Jq, aVar.Jr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path iu() {
        return this.path;
    }
}
