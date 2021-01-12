package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.o;
/* loaded from: classes9.dex */
public class l implements com.baidu.live.lottie.model.content.b {
    private final e bpT;
    private final m<PointF, PointF> bpU;
    private final g bpV;
    private final b bpW;
    private final d bpX;
    @Nullable
    private final b bpY;
    @Nullable
    private final b bpZ;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.bpT = eVar;
        this.bpU = mVar;
        this.bpV = gVar;
        this.bpW = bVar;
        this.bpX = dVar;
        this.bpY = bVar2;
        this.bpZ = bVar3;
    }

    public e LW() {
        return this.bpT;
    }

    public m<PointF, PointF> LX() {
        return this.bpU;
    }

    public g LY() {
        return this.bpV;
    }

    public b LZ() {
        return this.bpW;
    }

    public d Ma() {
        return this.bpX;
    }

    @Nullable
    public b Mb() {
        return this.bpY;
    }

    @Nullable
    public b Mc() {
        return this.bpZ;
    }

    public o Md() {
        return new o(this);
    }

    @Override // com.baidu.live.lottie.model.content.b
    @Nullable
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return null;
    }
}
