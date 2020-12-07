package com.baidu.swan.apps.performance.a;
/* loaded from: classes25.dex */
public class a {
    private String cCS;
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
        return this.cCS;
    }

    public void rC(String str) {
        this.cCS = str;
    }

    public long asz() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.cCS + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
