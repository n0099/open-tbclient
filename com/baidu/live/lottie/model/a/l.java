package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.o;
/* loaded from: classes10.dex */
public class l implements com.baidu.live.lottie.model.content.b {
    @Nullable
    private final b btA;
    @Nullable
    private final b btB;
    private final e btv;
    private final m<PointF, PointF> btw;
    private final g btx;
    private final b bty;
    private final d btz;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.btv = eVar;
        this.btw = mVar;
        this.btx = gVar;
        this.bty = bVar;
        this.btz = dVar;
        this.btA = bVar2;
        this.btB = bVar3;
    }

    public e Nu() {
        return this.btv;
    }

    public m<PointF, PointF> Nv() {
        return this.btw;
    }

    public g Nw() {
        return this.btx;
    }

    public b Nx() {
        return this.bty;
    }

    public d Ny() {
        return this.btz;
    }

    @Nullable
    public b Nz() {
        return this.btA;
    }

    @Nullable
    public b NA() {
        return this.btB;
    }

    public o NB() {
        return new o(this);
    }

    @Override // com.baidu.live.lottie.model.content.b
    @Nullable
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return null;
    }
}
