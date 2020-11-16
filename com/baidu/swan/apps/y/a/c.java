package com.baidu.swan.apps.y.a;
/* loaded from: classes7.dex */
public class c {
    protected boolean dex;
    protected int dfi;
    protected String dfj;
    protected long dfk;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.dex = false;
        this.dfi = i;
        this.dfj = str;
    }

    public c(int i, String str, long j) {
        this.dex = false;
        this.dfi = i;
        this.dfj = str;
        this.dfk = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.dex = false;
        this.dfi = i;
        this.dfj = str;
        this.dfk = j;
        this.dex = z;
    }

    public int getId() {
        return this.dfi;
    }

    public String aBS() {
        return this.dfj;
    }

    public long aBT() {
        return this.dfk;
    }

    public boolean aBU() {
        return this.dex;
    }
}
