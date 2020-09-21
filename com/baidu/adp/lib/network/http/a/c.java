package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private int Lz;
    private String Mh;
    private String Mk;
    private int Ml;
    private long Mm;
    private String exception;
    private boolean Mi = false;
    private boolean Mj = false;
    private int Ln = 0;

    public void am(boolean z) {
        this.Mi = z;
    }

    public boolean mI() {
        return this.Mj;
    }

    public void an(boolean z) {
        this.Mj = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void ar(int i) {
        this.Ln = i;
    }

    public void mJ() {
        this.exception = "";
    }

    public void bM(String str) {
        this.Mk = str;
    }

    public String mK() {
        return this.Mk;
    }

    public void as(int i) {
        this.Ml = i;
    }

    public void G(long j) {
        this.Mm = j;
    }

    public String toString() {
        return "isFromNet_" + this.Mi + "-statType_" + this.Ml + "-dnsErr_" + this.exception + "-hasRetry_" + this.Ln + "-cost_" + this.Mm + "-ipIndex_" + this.Lz + "-ipResult_" + this.Mh;
    }

    public String mL() {
        return this.Mh;
    }

    public void bN(String str) {
        this.Mh = str;
    }

    public void ao(int i) {
        this.Lz = i;
    }
}
