package com.baidu.swan.pms.c.d;
/* loaded from: classes14.dex */
public class c extends g {
    private String dGo;
    private long dGp;
    private long dGq;
    private String dGr;
    private String dGs;
    private int dGt;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.dGp = -1L;
        this.dGq = -1L;
        this.dGt = -1;
        this.dGo = str;
    }

    public c lT(int i) {
        this.dGt = i;
        return this;
    }

    public int aUm() {
        return this.dGt;
    }

    public c wI(String str) {
        this.dGr = str;
        return this;
    }

    public c cl(long j) {
        this.dGp = j;
        return this;
    }

    public c cm(long j) {
        this.dGq = j;
        return this;
    }

    public c wJ(String str) {
        this.dGs = str;
        return this;
    }

    public c wK(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.dGo;
    }

    public long aUk() {
        return this.dGp;
    }

    public long aUl() {
        return this.dGq;
    }

    public String aUn() {
        return this.dGr;
    }

    public String aUo() {
        return this.dGs;
    }

    public String getPath() {
        return this.mPath;
    }
}
