package com.baidu.ar.c;
/* loaded from: classes11.dex */
public abstract class b {
    private String I;
    private Object lC = null;
    private long lD = 0;
    private long mTimestamp;

    public void S(String str) {
        this.I = str;
    }

    public void a(Object obj) {
        this.lC = obj;
    }

    public String cD() {
        return this.I;
    }

    public Object cE() {
        return this.lC;
    }

    public long cF() {
        return this.lD;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void p(long j) {
        this.lD = j;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
