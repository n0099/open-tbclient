package com.baidu.ar.c;
/* loaded from: classes3.dex */
public abstract class b {
    private String J;
    private Object lf = null;
    private long lg = 0;
    private long mTimestamp;

    public void S(String str) {
        this.J = str;
    }

    public void a(Object obj) {
        this.lf = obj;
    }

    public String cl() {
        return this.J;
    }

    public Object cm() {
        return this.lf;
    }

    public long cn() {
        return this.lg;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void q(long j) {
        this.lg = j;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
