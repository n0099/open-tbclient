package com.baidu.ar.statistic;

import java.lang.reflect.Constructor;
/* loaded from: classes10.dex */
class o implements f {
    private f wR;

    public o() {
        Constructor<?> a2 = com.baidu.ar.h.n.a("com.baidu.ar.statistic.performance.PerformanceStatisticApi", new Class[0]);
        if (a2 != null) {
            this.wR = (f) com.baidu.ar.h.n.a(a2, new Object[0]);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        if (this.wR != null) {
            this.wR.onFrameIn();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        if (this.wR != null) {
            this.wR.onFrameOut();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        if (this.wR != null) {
            this.wR.recordAlgoTimeCost(str, str2, j, i);
        }
    }
}
