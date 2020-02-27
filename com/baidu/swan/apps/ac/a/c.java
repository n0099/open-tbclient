package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class c {
    protected int bFU;
    protected String bFV;
    protected long bFW;
    protected boolean bFl;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.bFl = false;
        this.bFU = i;
        this.bFV = str;
    }

    public c(int i, String str, long j) {
        this.bFl = false;
        this.bFU = i;
        this.bFV = str;
        this.bFW = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.bFl = false;
        this.bFU = i;
        this.bFV = str;
        this.bFW = j;
        this.bFl = z;
    }

    public int getId() {
        return this.bFU;
    }

    public String YP() {
        return this.bFV;
    }

    public long YQ() {
        return this.bFW;
    }

    public boolean YR() {
        return this.bFl;
    }
}
