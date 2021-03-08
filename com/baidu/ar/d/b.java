package com.baidu.ar.d;
/* loaded from: classes3.dex */
public abstract class b {
    private String J;
    private long mTimestamp;
    private Object mz = null;
    private long mA = 0;

    public void W(String str) {
        this.J = str;
    }

    public String dc() {
        return this.J;
    }

    public Object dd() {
        return this.mz;
    }

    public long de() {
        return this.mA;
    }

    public void g(Object obj) {
        this.mz = obj;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void n(long j) {
        this.mA = j;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
