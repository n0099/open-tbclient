package com.baidu.swan.apps.performance.a;
/* loaded from: classes9.dex */
public class a {
    private String cHI;
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
        return this.cHI;
    }

    public void rv(String str) {
        this.cHI = str;
    }

    public long atR() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.cHI + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
