package com.baidu.swan.apps.performance.c;
/* loaded from: classes2.dex */
public class a implements e {
    private long mStartTime = -1;
    private long aGl = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void N(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void O(long j) {
        this.aGl = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long Ie() {
        if (this.mStartTime < 0 || this.aGl < 0) {
            return -1L;
        }
        return this.aGl - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageInitRender";
    }
}
