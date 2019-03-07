package com.baidu.swan.apps.performance.c;
/* loaded from: classes2.dex */
public class b implements e {
    private long mStartTime = -1;
    private long aEo = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void B(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void C(long j) {
        this.aEo = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long FY() {
        if (this.mStartTime < 0 || this.aEo < 0) {
            return -1L;
        }
        return this.aEo - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageSwitchCost";
    }
}
