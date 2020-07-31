package com.baidu.swan.apps.performance.a;
/* loaded from: classes7.dex */
public class a {
    private String bPs;
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

    public void nq(String str) {
        this.bPs = str;
    }

    public String aof() {
        return !this.bPs.startsWith("/") ? this.bPs : this.bPs.substring(1);
    }

    public long aog() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.bPs + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
