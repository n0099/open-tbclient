package com.baidu.swan.apps.performance.a;
/* loaded from: classes8.dex */
public class a {
    private String cGS;
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
        return this.cGS;
    }

    public void qJ(String str) {
        this.cGS = str;
    }

    public long aqx() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.cGS + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
