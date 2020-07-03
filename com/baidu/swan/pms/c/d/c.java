package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class c extends f {
    private String drn;
    private int dro;
    private long drp;
    private String drq;
    private String drr;
    private int drt;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.dro = -1;
        this.drp = -1L;
        this.drt = -1;
        this.drn = str;
    }

    public c jt(int i) {
        this.drt = i;
        return this;
    }

    public int aHW() {
        return this.drt;
    }

    public c tv(String str) {
        this.drq = str;
        return this;
    }

    public c ju(int i) {
        this.dro = i;
        return this;
    }

    public c bO(long j) {
        this.drp = j;
        return this;
    }

    public c tw(String str) {
        this.drr = str;
        return this;
    }

    public c tx(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.drn;
    }

    public int aHU() {
        return this.dro;
    }

    public long aHV() {
        return this.drp;
    }

    public String aHX() {
        return this.drq;
    }

    public String aHY() {
        return this.drr;
    }

    public String getPath() {
        return this.mPath;
    }
}
