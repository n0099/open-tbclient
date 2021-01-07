package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public class c extends g {
    private String exJ;
    private long exK;
    private long exL;
    private String exM;
    private String exN;
    private int exO;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.exK = -1L;
        this.exL = -1L;
        this.exO = -1;
        this.exJ = str;
    }

    public c nz(int i) {
        this.exO = i;
        return this;
    }

    public int bgU() {
        return this.exO;
    }

    public c yV(String str) {
        this.exM = str;
        return this;
    }

    public c ds(long j) {
        this.exK = j;
        return this;
    }

    public c dt(long j) {
        this.exL = j;
        return this;
    }

    public c yW(String str) {
        this.exN = str;
        return this;
    }

    public c yX(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.exJ;
    }

    public long bgS() {
        return this.exK;
    }

    public long bgT() {
        return this.exL;
    }

    public String bgV() {
        return this.exM;
    }

    public String bgW() {
        return this.exN;
    }

    public String getPath() {
        return this.mPath;
    }
}
