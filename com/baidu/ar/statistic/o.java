package com.baidu.ar.statistic;

import java.lang.reflect.Constructor;
/* loaded from: classes3.dex */
public class o implements f {
    public f wR;

    public o() {
        Constructor<?> a = com.baidu.ar.h.n.a("com.baidu.ar.statistic.performance.PerformanceStatisticApi", new Class[0]);
        if (a != null) {
            this.wR = (f) com.baidu.ar.h.n.a(a, new Object[0]);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        f fVar = this.wR;
        if (fVar != null) {
            fVar.onFrameIn();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        f fVar = this.wR;
        if (fVar != null) {
            fVar.onFrameOut();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        f fVar = this.wR;
        if (fVar != null) {
            fVar.recordAlgoTimeCost(str, str2, j, i);
        }
    }
}
