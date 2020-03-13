package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class c {
    protected int bFW;
    protected String bFX;
    protected long bFY;
    protected boolean bFn;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.bFn = false;
        this.bFW = i;
        this.bFX = str;
    }

    public c(int i, String str, long j) {
        this.bFn = false;
        this.bFW = i;
        this.bFX = str;
        this.bFY = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.bFn = false;
        this.bFW = i;
        this.bFX = str;
        this.bFY = j;
        this.bFn = z;
    }

    public int getId() {
        return this.bFW;
    }

    public String YR() {
        return this.bFX;
    }

    public long YS() {
        return this.bFY;
    }

    public boolean YT() {
        return this.bFn;
    }
}
