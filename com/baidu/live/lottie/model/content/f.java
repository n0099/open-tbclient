package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.a.a.n;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes9.dex */
public class f implements b {
    private final m<PointF, PointF> bpU;
    private final com.baidu.live.lottie.model.a.f bqa;
    private final com.baidu.live.lottie.model.a.b bqt;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.b bVar) {
        this.name = str;
        this.bpU = mVar;
        this.bqa = fVar;
        this.bqt = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.b Mw() {
        return this.bqt;
    }

    public com.baidu.live.lottie.model.a.f Me() {
        return this.bqa;
    }

    public m<PointF, PointF> LX() {
        return this.bpU;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new n(hVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.bpU + ", size=" + this.bqa + '}';
    }
}
