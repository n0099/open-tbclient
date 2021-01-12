package com.baidu.swan.apps.y.a;
/* loaded from: classes8.dex */
public class c {
    protected boolean dlE;
    protected int dmq;
    protected String dmr;
    protected long dms;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.dlE = false;
        this.dmq = i;
        this.dmr = str;
    }

    public c(int i, String str, long j) {
        this.dlE = false;
        this.dmq = i;
        this.dmr = str;
        this.dms = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.dlE = false;
        this.dmq = i;
        this.dmr = str;
        this.dms = j;
        this.dlE = z;
    }

    public int getId() {
        return this.dmq;
    }

    public String aCC() {
        return this.dmr;
    }

    public long aCD() {
        return this.dms;
    }

    public boolean aCE() {
        return this.dlE;
    }
}
