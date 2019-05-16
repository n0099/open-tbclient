package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class b extends e {
    private String bsT;
    private int bsU;
    private String bsV;
    private long bsW;
    private String bsX;
    private String wV;

    public b(String str, int i) {
        super(i);
        this.bsU = -1;
        this.bsW = -1L;
        this.bsT = str;
    }

    public b kp(String str) {
        this.bsV = str;
        return this;
    }

    public b fH(int i) {
        this.bsU = i;
        return this;
    }

    public b ag(long j) {
        this.bsW = j;
        return this;
    }

    public b kq(String str) {
        this.bsX = str;
        return this;
    }

    public b kr(String str) {
        this.wV = str;
        return this;
    }

    public String getBundleId() {
        return this.bsT;
    }

    public int VR() {
        return this.bsU;
    }

    public long VS() {
        return this.bsW;
    }

    public String VT() {
        return this.bsV;
    }

    public String VU() {
        return this.bsX;
    }

    public String getPath() {
        return this.wV;
    }
}
