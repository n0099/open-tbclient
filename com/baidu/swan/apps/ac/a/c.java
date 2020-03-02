package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class c {
    protected int bFV;
    protected String bFW;
    protected long bFX;
    protected boolean bFm;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.bFm = false;
        this.bFV = i;
        this.bFW = str;
    }

    public c(int i, String str, long j) {
        this.bFm = false;
        this.bFV = i;
        this.bFW = str;
        this.bFX = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.bFm = false;
        this.bFV = i;
        this.bFW = str;
        this.bFX = j;
        this.bFm = z;
    }

    public int getId() {
        return this.bFV;
    }

    public String YR() {
        return this.bFW;
    }

    public long YS() {
        return this.bFX;
    }

    public boolean YT() {
        return this.bFm;
    }
}
