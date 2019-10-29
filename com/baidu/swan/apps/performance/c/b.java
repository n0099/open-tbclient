package com.baidu.swan.apps.performance.c;
/* loaded from: classes2.dex */
public class b implements e {
    private long mStartTime = -1;
    private long baF = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void ag(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void ah(long j) {
        this.baF = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long NP() {
        if (this.mStartTime < 0 || this.baF < 0) {
            return -1L;
        }
        return this.baF - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageSwitchCost";
    }
}
