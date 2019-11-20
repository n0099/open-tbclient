package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class b extends e {
    private String bMb;
    private int bMc;
    private String bMd;
    private long bMe;
    private String bMf;
    private String mPath;

    public b(String str, int i) {
        super(i);
        this.bMc = -1;
        this.bMe = -1L;
        this.bMb = str;
    }

    public b la(String str) {
        this.bMd = str;
        return this;
    }

    public b gG(int i) {
        this.bMc = i;
        return this;
    }

    public b az(long j) {
        this.bMe = j;
        return this;
    }

    public b lb(String str) {
        this.bMf = str;
        return this;
    }

    public b lc(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.bMb;
    }

    public int abB() {
        return this.bMc;
    }

    public long abC() {
        return this.bMe;
    }

    public String abD() {
        return this.bMd;
    }

    public String abE() {
        return this.bMf;
    }

    public String getPath() {
        return this.mPath;
    }
}
