package com.baidu.ar.statistic;

import java.lang.reflect.Constructor;
/* loaded from: classes10.dex */
class o implements f {
    private f wd;

    public o() {
        Constructor<?> a = com.baidu.ar.g.n.a("com.baidu.ar.statistic.performance.PerformanceStatisticApi", new Class[0]);
        if (a != null) {
            this.wd = (f) com.baidu.ar.g.n.a(a, new Object[0]);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        if (this.wd != null) {
            this.wd.onFrameIn();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        if (this.wd != null) {
            this.wd.onFrameOut();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        if (this.wd != null) {
            this.wd.recordAlgoTimeCost(str, str2, j, i);
        }
    }
}
