package com.baidu.swan.apps.y.a;
/* loaded from: classes8.dex */
public class c {
    protected boolean cDD;
    protected int cEp;
    protected String cEq;
    protected long cEr;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.cDD = false;
        this.cEp = i;
        this.cEq = str;
    }

    public c(int i, String str, long j) {
        this.cDD = false;
        this.cEp = i;
        this.cEq = str;
        this.cEr = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.cDD = false;
        this.cEp = i;
        this.cEq = str;
        this.cEr = j;
        this.cDD = z;
    }

    public int getId() {
        return this.cEp;
    }

    public String auM() {
        return this.cEq;
    }

    public long auN() {
        return this.cEr;
    }

    public boolean auO() {
        return this.cDD;
    }
}
