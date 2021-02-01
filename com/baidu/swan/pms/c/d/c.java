package com.baidu.swan.pms.c.d;
/* loaded from: classes3.dex */
public class c extends g {
    private String evc;
    private long evd;
    private long eve;
    private String evf;
    private String evg;
    private int evh;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.evd = -1L;
        this.eve = -1L;
        this.evh = -1;
        this.evc = str;
    }

    public c lW(int i) {
        this.evh = i;
        return this;
    }

    public int bdn() {
        return this.evh;
    }

    public c yd(String str) {
        this.evf = str;
        return this;
    }

    public c dy(long j) {
        this.evd = j;
        return this;
    }

    public c dz(long j) {
        this.eve = j;
        return this;
    }

    public c ye(String str) {
        this.evg = str;
        return this;
    }

    public c yf(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.evc;
    }

    public long bdl() {
        return this.evd;
    }

    public long bdm() {
        return this.eve;
    }

    public String bdo() {
        return this.evf;
    }

    public String bdp() {
        return this.evg;
    }

    public String getPath() {
        return this.mPath;
    }
}
