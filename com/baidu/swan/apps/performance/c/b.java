package com.baidu.swan.apps.performance.c;
/* loaded from: classes2.dex */
public class b implements e {
    private long mStartTime = -1;
    private long aHr = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void N(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void O(long j) {
        this.aHr = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long IV() {
        if (this.mStartTime < 0 || this.aHr < 0) {
            return -1L;
        }
        return this.aHr - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageSwitchCost";
    }
}
