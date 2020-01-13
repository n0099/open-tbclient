package com.baidu.swan.apps.ac.a;
/* loaded from: classes10.dex */
public class c {
    protected int bBO;
    protected String bBP;
    protected long bBQ;
    protected boolean bBf;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.bBf = false;
        this.bBO = i;
        this.bBP = str;
    }

    public c(int i, String str, long j) {
        this.bBf = false;
        this.bBO = i;
        this.bBP = str;
        this.bBQ = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.bBf = false;
        this.bBO = i;
        this.bBP = str;
        this.bBQ = j;
        this.bBf = z;
    }

    public int getId() {
        return this.bBO;
    }

    public String WB() {
        return this.bBP;
    }

    public long WC() {
        return this.bBQ;
    }

    public boolean WD() {
        return this.bBf;
    }
}
