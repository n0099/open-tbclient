package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private int LU;
    private String MA;
    private int MC;
    private long MD;
    private String Mx;
    private String exception;
    private boolean My = false;
    private boolean Mz = false;
    private int LD = 0;

    public void am(boolean z) {
        this.My = z;
    }

    public boolean mJ() {
        return this.Mz;
    }

    public void an(boolean z) {
        this.Mz = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void ar(int i) {
        this.LD = i;
    }

    public void mK() {
        this.exception = "";
    }

    public void bM(String str) {
        this.MA = str;
    }

    public String mL() {
        return this.MA;
    }

    public void as(int i) {
        this.MC = i;
    }

    public void G(long j) {
        this.MD = j;
    }

    public String toString() {
        return "isFromNet_" + this.My + "-statType_" + this.MC + "-dnsErr_" + this.exception + "-hasRetry_" + this.LD + "-cost_" + this.MD + "-ipIndex_" + this.LU + "-ipResult_" + this.Mx;
    }

    public String mM() {
        return this.Mx;
    }

    public void bN(String str) {
        this.Mx = str;
    }

    public void ao(int i) {
        this.LU = i;
    }
}
