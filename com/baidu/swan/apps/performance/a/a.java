package com.baidu.swan.apps.performance.a;
/* loaded from: classes7.dex */
public class a {
    private String cwa;
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
        return this.cwa;
    }

    public void qV(String str) {
        this.cwa = str;
    }

    public long apr() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.cwa + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
