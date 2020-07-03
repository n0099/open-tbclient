package com.baidu.ar.statistic;

import java.lang.reflect.Constructor;
/* loaded from: classes3.dex */
class o implements f {
    private f vA;

    public o() {
        Constructor<?> a = com.baidu.ar.f.l.a("com.baidu.ar.statistic.performance.PerformanceStatisticApi", new Class[0]);
        if (a != null) {
            this.vA = (f) com.baidu.ar.f.l.a(a, new Object[0]);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        if (this.vA != null) {
            this.vA.onFrameIn();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        if (this.vA != null) {
            this.vA.onFrameOut();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        if (this.vA != null) {
            this.vA.recordAlgoTimeCost(str, str2, j, i);
        }
    }
}
