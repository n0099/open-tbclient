package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private String LW;
    private String LZ;
    private int Lp;
    private int Ma;
    private long Mb;
    private String exception;
    private boolean LX = false;
    private boolean LY = false;
    private int Ld = 0;

    public void am(boolean z) {
        this.LX = z;
    }

    public boolean mD() {
        return this.LY;
    }

    public void an(boolean z) {
        this.LY = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void ao(int i) {
        this.Ld = i;
    }

    public void mE() {
        this.exception = "";
    }

    public void bK(String str) {
        this.LZ = str;
    }

    public String mF() {
        return this.LZ;
    }

    public void ap(int i) {
        this.Ma = i;
    }

    public void G(long j) {
        this.Mb = j;
    }

    public String toString() {
        return "isFromNet_" + this.LX + "-statType_" + this.Ma + "-dnsErr_" + this.exception + "-hasRetry_" + this.Ld + "-cost_" + this.Mb + "-ipIndex_" + this.Lp + "-ipResult_" + this.LW;
    }

    public String mG() {
        return this.LW;
    }

    public void bL(String str) {
        this.LW = str;
    }

    public void al(int i) {
        this.Lp = i;
    }
}
