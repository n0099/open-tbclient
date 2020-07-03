package com.baidu.swan.apps.performance.a;
/* loaded from: classes11.dex */
public class a {
    private String bOA;
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

    public void mO(String str) {
        this.bOA = str;
    }

    public String amL() {
        return !this.bOA.startsWith("/") ? this.bOA : this.bOA.substring(1);
    }

    public long amM() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.bOA + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
