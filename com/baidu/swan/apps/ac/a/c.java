package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class c {
    protected boolean bFy;
    protected int bGh;
    protected String bGi;
    protected long bGj;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.bFy = false;
        this.bGh = i;
        this.bGi = str;
    }

    public c(int i, String str, long j) {
        this.bFy = false;
        this.bGh = i;
        this.bGi = str;
        this.bGj = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.bFy = false;
        this.bGh = i;
        this.bGi = str;
        this.bGj = j;
        this.bFy = z;
    }

    public int getId() {
        return this.bGh;
    }

    public String YU() {
        return this.bGi;
    }

    public long YV() {
        return this.bGj;
    }

    public boolean YW() {
        return this.bFy;
    }
}
