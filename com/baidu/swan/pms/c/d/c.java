package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public class c extends g {
    private String esV;
    private long esW;
    private long esX;
    private String esY;
    private String esZ;
    private int eta;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.esW = -1L;
        this.esX = -1L;
        this.eta = -1;
        this.esV = str;
    }

    public c lT(int i) {
        this.eta = i;
        return this;
    }

    public int bda() {
        return this.eta;
    }

    public c xK(String str) {
        this.esY = str;
        return this;
    }

    public c ds(long j) {
        this.esW = j;
        return this;
    }

    public c dt(long j) {
        this.esX = j;
        return this;
    }

    public c xL(String str) {
        this.esZ = str;
        return this;
    }

    public c xM(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.esV;
    }

    public long bcY() {
        return this.esW;
    }

    public long bcZ() {
        return this.esX;
    }

    public String bdb() {
        return this.esY;
    }

    public String bdc() {
        return this.esZ;
    }

    public String getPath() {
        return this.mPath;
    }
}
