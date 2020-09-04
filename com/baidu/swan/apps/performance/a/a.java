package com.baidu.swan.apps.performance.a;
/* loaded from: classes8.dex */
public class a {
    private String bUW;
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
        return this.bUW;
    }

    public void pp(String str) {
        this.bUW = str;
    }

    public long aij() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.bUW + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
