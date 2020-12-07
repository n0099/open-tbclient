package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public class c extends g {
    private String eob;
    private long eoc;
    private long eod;
    private String eoe;
    private String eog;
    private int eoh;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.eoc = -1L;
        this.eod = -1L;
        this.eoh = -1;
        this.eob = str;
    }

    public c nq(int i) {
        this.eoh = i;
        return this;
    }

    public int bey() {
        return this.eoh;
    }

    public c yW(String str) {
        this.eoe = str;
        return this;
    }

    public c dr(long j) {
        this.eoc = j;
        return this;
    }

    public c ds(long j) {
        this.eod = j;
        return this;
    }

    public c yX(String str) {
        this.eog = str;
        return this;
    }

    public c yY(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.eob;
    }

    public long bew() {
        return this.eoc;
    }

    public long bex() {
        return this.eod;
    }

    public String bez() {
        return this.eoe;
    }

    public String beA() {
        return this.eog;
    }

    public String getPath() {
        return this.mPath;
    }
}
