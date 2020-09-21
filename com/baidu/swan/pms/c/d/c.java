package com.baidu.swan.pms.c.d;
/* loaded from: classes24.dex */
public class c extends g {
    private String dIs;
    private long dIt;
    private long dIu;
    private String dIv;
    private String dIw;
    private int dIx;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.dIt = -1L;
        this.dIu = -1L;
        this.dIx = -1;
        this.dIs = str;
    }

    public c me(int i) {
        this.dIx = i;
        return this;
    }

    public int aUY() {
        return this.dIx;
    }

    public c xb(String str) {
        this.dIv = str;
        return this;
    }

    public c cm(long j) {
        this.dIt = j;
        return this;
    }

    public c cn(long j) {
        this.dIu = j;
        return this;
    }

    public c xc(String str) {
        this.dIw = str;
        return this;
    }

    public c xd(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.dIs;
    }

    public long aUW() {
        return this.dIt;
    }

    public long aUX() {
        return this.dIu;
    }

    public String aUZ() {
        return this.dIv;
    }

    public String aVa() {
        return this.dIw;
    }

    public String getPath() {
        return this.mPath;
    }
}
