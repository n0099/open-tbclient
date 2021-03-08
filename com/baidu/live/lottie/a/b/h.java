package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class h extends com.baidu.live.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.baidu.live.lottie.e eVar, com.baidu.live.lottie.e.a<PointF> aVar) {
        super(eVar, aVar.Jk, aVar.Jl, aVar.Jm, aVar.Dr, aVar.Jn);
        boolean z = (this.Jl == 0 || this.Jk == 0 || !((PointF) this.Jk).equals(((PointF) this.Jl).x, ((PointF) this.Jl).y)) ? false : true;
        if (this.Jl != 0 && !z) {
            this.path = com.baidu.live.lottie.d.f.b((PointF) this.Jk, (PointF) this.Jl, aVar.Jq, aVar.Jr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path iu() {
        return this.path;
    }
}
