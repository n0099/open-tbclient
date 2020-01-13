package com.baidu.swan.pms.c.d;
/* loaded from: classes10.dex */
public class c extends f {
    private String cya;
    private int cyb;
    private long cyc;
    private String cyd;
    private String cye;
    private int cyf;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.cyb = -1;
        this.cyc = -1L;
        this.cyf = -1;
        this.cya = str;
    }

    public c is(int i) {
        this.cyf = i;
        return this;
    }

    public int arW() {
        return this.cyf;
    }

    public c qh(String str) {
        this.cyd = str;
        return this;
    }

    public c it(int i) {
        this.cyb = i;
        return this;
    }

    public c bh(long j) {
        this.cyc = j;
        return this;
    }

    public c qi(String str) {
        this.cye = str;
        return this;
    }

    public c qj(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.cya;
    }

    public int arU() {
        return this.cyb;
    }

    public long arV() {
        return this.cyc;
    }

    public String arX() {
        return this.cyd;
    }

    public String arY() {
        return this.cye;
    }

    public String getPath() {
        return this.mPath;
    }
}
