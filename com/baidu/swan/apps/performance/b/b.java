package com.baidu.swan.apps.performance.b;
/* loaded from: classes9.dex */
public class b implements e {
    private long mStartTime = -1;
    private long bDa = -1;

    @Override // com.baidu.swan.apps.performance.b.e
    public void setStart(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public void setEnd(long j) {
        this.bDa = j;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public long Xn() {
        if (this.mStartTime < 0 || this.bDa < 0) {
            return -1L;
        }
        return this.bDa - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public String getType() {
        return "PageSwitchCost";
    }
}
