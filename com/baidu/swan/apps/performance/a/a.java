package com.baidu.swan.apps.performance.a;
/* loaded from: classes3.dex */
public class a {
    private String bWX;
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
        return this.bWX;
    }

    public void pI(String str) {
        this.bWX = str;
    }

    public long aiT() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.bWX + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
