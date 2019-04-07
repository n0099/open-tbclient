package com.baidu.swan.apps.performance.c;
/* loaded from: classes2.dex */
public class b implements e {
    private long mStartTime = -1;
    private long aEs = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void B(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void C(long j) {
        this.aEs = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long FW() {
        if (this.mStartTime < 0 || this.aEs < 0) {
            return -1L;
        }
        return this.aEs - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageSwitchCost";
    }
}
