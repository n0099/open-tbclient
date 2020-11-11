package com.baidu.swan.apps.y.a;
/* loaded from: classes10.dex */
public class c {
    protected int dgP;
    protected String dgQ;
    protected long dgR;
    protected boolean dge;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.dge = false;
        this.dgP = i;
        this.dgQ = str;
    }

    public c(int i, String str, long j) {
        this.dge = false;
        this.dgP = i;
        this.dgQ = str;
        this.dgR = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.dge = false;
        this.dgP = i;
        this.dgQ = str;
        this.dgR = j;
        this.dge = z;
    }

    public int getId() {
        return this.dgP;
    }

    public String aCA() {
        return this.dgQ;
    }

    public long aCB() {
        return this.dgR;
    }

    public boolean aCC() {
        return this.dge;
    }
}
