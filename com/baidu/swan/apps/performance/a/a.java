package com.baidu.swan.apps.performance.a;
/* loaded from: classes10.dex */
public class a {
    private String cxK;
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
        return this.cxK;
    }

    public void rb(String str) {
        this.cxK = str;
    }

    public long apZ() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.cxK + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
