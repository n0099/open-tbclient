package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private String exception;
    private int qV;
    private String rD;
    private String rG;
    private int rH;
    private long rI;
    private boolean rE = false;
    private boolean rF = false;
    private int qK = 0;

    public void J(boolean z) {
        this.rE = z;
    }

    public boolean gj() {
        return this.rF;
    }

    public void K(boolean z) {
        this.rF = z;
    }

    public void aq(String str) {
        this.exception = str;
    }

    public void R(int i) {
        this.qK = i;
    }

    public void gk() {
        this.exception = "";
    }

    public void ar(String str) {
        this.rG = str;
    }

    public String gl() {
        return this.rG;
    }

    public void S(int i) {
        this.rH = i;
    }

    public void i(long j) {
        this.rI = j;
    }

    public String toString() {
        return "isFromNet_" + this.rE + "-statType_" + this.rH + "-dnsErr_" + this.exception + "-hasRetry_" + this.qK + "-cost_" + this.rI + "-ipIndex_" + this.qV + "-ipResult_" + this.rD;
    }

    public String gm() {
        return this.rD;
    }

    public void as(String str) {
        this.rD = str;
    }

    public void O(int i) {
        this.qV = i;
    }
}
