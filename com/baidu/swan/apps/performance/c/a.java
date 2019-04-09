package com.baidu.swan.apps.performance.c;
/* loaded from: classes2.dex */
public class a implements e {
    private long mStartTime = -1;
    private long aEt = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void B(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void C(long j) {
        this.aEt = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long FW() {
        if (this.mStartTime < 0 || this.aEt < 0) {
            return -1L;
        }
        return this.aEt - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageInitRender";
    }
}
