package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class c extends f {
    private String cCl;
    private int cCm;
    private long cCn;
    private String cCo;
    private String cCp;
    private int cCq;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.cCm = -1;
        this.cCn = -1L;
        this.cCq = -1;
        this.cCl = str;
    }

    public c iJ(int i) {
        this.cCq = i;
        return this;
    }

    public int aup() {
        return this.cCq;
    }

    public c qv(String str) {
        this.cCo = str;
        return this;
    }

    public c iK(int i) {
        this.cCm = i;
        return this;
    }

    public c bl(long j) {
        this.cCn = j;
        return this;
    }

    public c qw(String str) {
        this.cCp = str;
        return this;
    }

    public c qx(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.cCl;
    }

    public int aun() {
        return this.cCm;
    }

    public long auo() {
        return this.cCn;
    }

    public String auq() {
        return this.cCo;
    }

    public String aur() {
        return this.cCp;
    }

    public String getPath() {
        return this.mPath;
    }
}
