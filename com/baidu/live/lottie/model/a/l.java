package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.o;
/* loaded from: classes10.dex */
public class l implements com.baidu.live.lottie.model.content.b {
    private final e buH;
    private final m<PointF, PointF> buI;
    private final g buJ;
    private final b buK;
    private final d buL;
    @Nullable
    private final b buM;
    @Nullable
    private final b buN;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.buH = eVar;
        this.buI = mVar;
        this.buJ = gVar;
        this.buK = bVar;
        this.buL = dVar;
        this.buM = bVar2;
        this.buN = bVar3;
    }

    public e PR() {
        return this.buH;
    }

    public m<PointF, PointF> PS() {
        return this.buI;
    }

    public g PT() {
        return this.buJ;
    }

    public b PU() {
        return this.buK;
    }

    public d PV() {
        return this.buL;
    }

    @Nullable
    public b PW() {
        return this.buM;
    }

    @Nullable
    public b PX() {
        return this.buN;
    }

    public o PY() {
        return new o(this);
    }

    @Override // com.baidu.live.lottie.model.content.b
    @Nullable
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return null;
    }
}
