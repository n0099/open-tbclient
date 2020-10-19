package com.baidu.ar.d;
/* loaded from: classes14.dex */
public abstract class b {
    private String I;
    private long mTimestamp;
    private Object mk = null;
    private long ml = 0;

    public void T(String str) {
        this.I = str;
    }

    public String dd() {
        return this.I;
    }

    public Object de() {
        return this.mk;
    }

    public long df() {
        return this.ml;
    }

    public void g(Object obj) {
        this.mk = obj;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void p(long j) {
        this.ml = j;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
