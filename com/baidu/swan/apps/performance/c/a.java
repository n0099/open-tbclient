package com.baidu.swan.apps.performance.c;
/* loaded from: classes2.dex */
public class a implements e {
    private long mStartTime = -1;
    private long aGT = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void N(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void O(long j) {
        this.aGT = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long IR() {
        if (this.mStartTime < 0 || this.aGT < 0) {
            return -1L;
        }
        return this.aGT - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageInitRender";
    }
}
