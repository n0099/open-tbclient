package com.baidu.swan.apps.performance.a;
/* loaded from: classes11.dex */
public class a {
    private String bJM;
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

    public void mG(String str) {
        this.bJM = str;
    }

    public String alF() {
        return !this.bJM.startsWith("/") ? this.bJM : this.bJM.substring(1);
    }

    public long alG() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.bJM + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
