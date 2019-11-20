package com.baidu.swan.apps.performance.c;
/* loaded from: classes2.dex */
public class b implements e {
    private long mStartTime = -1;
    private long ban = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void af(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void ag(long j) {
        this.ban = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long NQ() {
        if (this.mStartTime < 0 || this.ban < 0) {
            return -1L;
        }
        return this.ban - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageSwitchCost";
    }
}
