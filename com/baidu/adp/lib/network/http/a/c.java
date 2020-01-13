package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private String exception;
    private int qU;
    private String rC;
    private String rF;
    private int rG;
    private long rH;
    private boolean rD = false;
    private boolean rE = false;
    private int qK = 0;

    public void J(boolean z) {
        this.rD = z;
    }

    public boolean gj() {
        return this.rE;
    }

    public void K(boolean z) {
        this.rE = z;
    }

    public void aq(String str) {
        this.exception = str;
    }

    public void O(int i) {
        this.qK = i;
    }

    public void gk() {
        this.exception = "";
    }

    public void ar(String str) {
        this.rF = str;
    }

    public String gl() {
        return this.rF;
    }

    public void P(int i) {
        this.rG = i;
    }

    public void i(long j) {
        this.rH = j;
    }

    public String toString() {
        return "isFromNet_" + this.rD + "-statType_" + this.rG + "-dnsErr_" + this.exception + "-hasRetry_" + this.qK + "-cost_" + this.rH + "-ipIndex_" + this.qU + "-ipResult_" + this.rC;
    }

    public String gm() {
        return this.rC;
    }

    public void as(String str) {
        this.rC = str;
    }

    public void L(int i) {
        this.qU = i;
    }
}
