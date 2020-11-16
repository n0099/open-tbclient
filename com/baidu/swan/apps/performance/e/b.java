package com.baidu.swan.apps.performance.e;
/* loaded from: classes7.dex */
public class b implements e {
    private long mStartTime = -1;
    private long mEndTime = -1;

    @Override // com.baidu.swan.apps.performance.e.e
    public void setStart(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.e.e
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.swan.apps.performance.e.e
    public long apr() {
        if (this.mStartTime < 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.e.e
    public String getType() {
        return "PageSwitchCost";
    }
}
