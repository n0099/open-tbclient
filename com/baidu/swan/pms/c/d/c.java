package com.baidu.swan.pms.c.d;
/* loaded from: classes14.dex */
public class c extends g {
    private String dGk;
    private long dGl;
    private long dGm;
    private String dGn;
    private String dGo;
    private int dGp;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.dGl = -1L;
        this.dGm = -1L;
        this.dGp = -1;
        this.dGk = str;
    }

    public c lT(int i) {
        this.dGp = i;
        return this;
    }

    public int aUm() {
        return this.dGp;
    }

    public c wH(String str) {
        this.dGn = str;
        return this;
    }

    public c cl(long j) {
        this.dGl = j;
        return this;
    }

    public c cm(long j) {
        this.dGm = j;
        return this;
    }

    public c wI(String str) {
        this.dGo = str;
        return this;
    }

    public c wJ(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.dGk;
    }

    public long aUk() {
        return this.dGl;
    }

    public long aUl() {
        return this.dGm;
    }

    public String aUn() {
        return this.dGn;
    }

    public String aUo() {
        return this.dGo;
    }

    public String getPath() {
        return this.mPath;
    }
}
