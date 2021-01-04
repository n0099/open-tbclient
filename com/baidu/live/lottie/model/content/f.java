package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.a.a.n;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes10.dex */
public class f implements b {
    private final m<PointF, PointF> buI;
    private final com.baidu.live.lottie.model.a.f buO;
    private final com.baidu.live.lottie.model.a.b bvh;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.b bVar) {
        this.name = str;
        this.buI = mVar;
        this.buO = fVar;
        this.bvh = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.b Qr() {
        return this.bvh;
    }

    public com.baidu.live.lottie.model.a.f PZ() {
        return this.buO;
    }

    public m<PointF, PointF> PS() {
        return this.buI;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new n(hVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.buI + ", size=" + this.buO + '}';
    }
}
