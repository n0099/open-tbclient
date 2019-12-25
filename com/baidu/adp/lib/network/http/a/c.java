package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private String exception;
    private String rB;
    private String rE;
    private int rF;
    private long rG;
    private int rH;
    private boolean rC = false;
    private boolean rD = false;
    private int qM = 0;

    public void J(boolean z) {
        this.rC = z;
    }

    public boolean gk() {
        return this.rD;
    }

    public void K(boolean z) {
        this.rD = z;
    }

    public void aq(String str) {
        this.exception = str;
    }

    public void N(int i) {
        this.qM = i;
    }

    public void gl() {
        this.exception = "";
    }

    public void ar(String str) {
        this.rE = str;
    }

    public String gm() {
        return this.rE;
    }

    public void O(int i) {
        this.rF = i;
    }

    public void i(long j) {
        this.rG = j;
    }

    public String toString() {
        return "isFromNet_" + this.rC + "-statType_" + this.rF + "-dnsErr_" + this.exception + "-hasRetry_" + this.qM + "-cost_" + this.rG + "-ipIndex_" + this.rH + "-ipResult_" + this.rB;
    }

    public String gn() {
        return this.rB;
    }

    public void as(String str) {
        this.rB = str;
    }

    public void P(int i) {
        this.rH = i;
    }
}
