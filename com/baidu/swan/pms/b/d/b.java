package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class b extends e {
    private String bui;
    private int buj;
    private String buk;
    private long bul;
    private String bum;
    private String wX;

    public b(String str, int i) {
        super(i);
        this.buj = -1;
        this.bul = -1L;
        this.bui = str;
    }

    public b ky(String str) {
        this.buk = str;
        return this;
    }

    public b fM(int i) {
        this.buj = i;
        return this;
    }

    public b ah(long j) {
        this.bul = j;
        return this;
    }

    public b kz(String str) {
        this.bum = str;
        return this;
    }

    public b kA(String str) {
        this.wX = str;
        return this;
    }

    public String getBundleId() {
        return this.bui;
    }

    public int WO() {
        return this.buj;
    }

    public long WP() {
        return this.bul;
    }

    public String WQ() {
        return this.buk;
    }

    public String WR() {
        return this.bum;
    }

    public String getPath() {
        return this.wX;
    }
}
