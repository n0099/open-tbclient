package com.baidu.swan.apps.ac.a;
/* loaded from: classes9.dex */
public class c {
    protected boolean bAs;
    protected int bBc;
    protected String bBd;
    protected long bBe;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.bAs = false;
        this.bBc = i;
        this.bBd = str;
    }

    public c(int i, String str, long j) {
        this.bAs = false;
        this.bBc = i;
        this.bBd = str;
        this.bBe = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.bAs = false;
        this.bBc = i;
        this.bBd = str;
        this.bBe = j;
        this.bAs = z;
    }

    public int getId() {
        return this.bBc;
    }

    public String We() {
        return this.bBd;
    }

    public long Wf() {
        return this.bBe;
    }

    public boolean Wg() {
        return this.bAs;
    }
}
