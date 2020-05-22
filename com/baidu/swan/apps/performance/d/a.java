package com.baidu.swan.apps.performance.d;
/* loaded from: classes11.dex */
public class a implements e {
    private long mStartTime = -1;
    private long mEndTime = -1;

    @Override // com.baidu.swan.apps.performance.d.e
    public void setStart(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.swan.apps.performance.d.e
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.swan.apps.performance.d.e
    public long alG() {
        if (this.mStartTime < 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - this.mStartTime;
    }

    @Override // com.baidu.swan.apps.performance.d.e
    public String getType() {
        return "PageInitRender";
    }
}
