package com.baidu.swan.apps.performance.a;
/* loaded from: classes10.dex */
public class a {
    private String crN;
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
        return this.crN;
    }

    public void qN(String str) {
        this.crN = str;
    }

    public long any() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.crN + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
