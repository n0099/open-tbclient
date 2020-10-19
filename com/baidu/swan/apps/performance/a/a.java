package com.baidu.swan.apps.performance.a;
/* loaded from: classes10.dex */
public class a {
    private String cjm;
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
        return this.cjm;
    }

    public void qu(String str) {
        this.cjm = str;
    }

    public long alE() {
        return this.mEnd - this.mStart;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.cjm + "', mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
