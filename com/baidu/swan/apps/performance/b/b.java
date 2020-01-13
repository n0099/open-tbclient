package com.baidu.swan.apps.performance.b;
/* loaded from: classes10.dex */
public class b implements e {
    private long mStartTime = -1;
    private long bDL = -1;

    @Override // com.baidu.swan.apps.performance.b.e
    public void setStart(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public void setEnd(long j) {
        this.bDL = j;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public long XK() {
        if (this.mStartTime < 0 || this.bDL < 0) {
            return -1L;
        }
        return this.bDL - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public String getType() {
        return "PageSwitchCost";
    }
}
