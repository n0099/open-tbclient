package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes10.dex */
public class a implements b {
    private final boolean FD;
    private final com.baidu.live.lottie.model.a.f btC;
    private final m<PointF, PointF> btw;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.baidu.live.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.btw = mVar;
        this.btC = fVar;
        this.FD = z;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.e(hVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> Nv() {
        return this.btw;
    }

    public com.baidu.live.lottie.model.a.f NC() {
        return this.btC;
    }

    public boolean isReversed() {
        return this.FD;
    }
}
