package com.baidu.swan.apps.y.a;
/* loaded from: classes8.dex */
public class c {
    protected boolean cDH;
    protected int cEt;
    protected String cEu;
    protected long cEv;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.cDH = false;
        this.cEt = i;
        this.cEu = str;
    }

    public c(int i, String str, long j) {
        this.cDH = false;
        this.cEt = i;
        this.cEu = str;
        this.cEv = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.cDH = false;
        this.cEt = i;
        this.cEu = str;
        this.cEv = j;
        this.cDH = z;
    }

    public int getId() {
        return this.cEt;
    }

    public String auM() {
        return this.cEu;
    }

    public long auN() {
        return this.cEv;
    }

    public boolean auO() {
        return this.cDH;
    }
}
