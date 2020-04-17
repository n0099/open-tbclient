package com.baidu.ar.statistic;

import java.lang.reflect.Constructor;
/* loaded from: classes3.dex */
class o implements f {
    private f va;

    public o() {
        Constructor<?> a = com.baidu.ar.f.l.a("com.baidu.ar.statistic.performance.PerformanceStatisticApi", new Class[0]);
        if (a != null) {
            this.va = (f) com.baidu.ar.f.l.a(a, new Object[0]);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        if (this.va != null) {
            this.va.onFrameIn();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        if (this.va != null) {
            this.va.onFrameOut();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        if (this.va != null) {
            this.va.recordAlgoTimeCost(str, str2, j, i);
        }
    }
}
