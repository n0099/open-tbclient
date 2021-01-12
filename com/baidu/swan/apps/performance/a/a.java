package com.baidu.swan.apps.performance.a;
/* loaded from: classes8.dex */
public class a {
    private String cCW;
    private long mEnd;
    private long mStart;

    public long getStart() {
        return this.mStart;
    }

    public void setStart(long j) {
        this.mStart = j;
    }

    public long getEnd() {
        return this.mEnd;
    }

    public void setEnd(long j) {
        this.mEnd = j;
    }

    public String getApiName() {
        return this.cCW;
    }

    public void qk(String str) {
        this.cCW = str;
    }

    public long apW() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.cCW + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
