package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class b extends e {
    private String btJ;
    private int btK;
    private String btL;
    private long btM;
    private String btN;
    private String wX;

    public b(String str, int i) {
        super(i);
        this.btK = -1;
        this.btM = -1L;
        this.btJ = str;
    }

    public b kw(String str) {
        this.btL = str;
        return this;
    }

    public b fL(int i) {
        this.btK = i;
        return this;
    }

    public b ah(long j) {
        this.btM = j;
        return this;
    }

    public b kx(String str) {
        this.btN = str;
        return this;
    }

    public b ky(String str) {
        this.wX = str;
        return this;
    }

    public String getBundleId() {
        return this.btJ;
    }

    public int WK() {
        return this.btK;
    }

    public long WL() {
        return this.btM;
    }

    public String WM() {
        return this.btL;
    }

    public String WN() {
        return this.btN;
    }

    public String getPath() {
        return this.wX;
    }
}
