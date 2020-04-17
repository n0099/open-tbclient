package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private int JW;
    private String KA;
    private String KE;
    private int KF;
    private long KG;
    private String exception;
    private boolean KC = false;
    private boolean KD = false;
    private int JL = 0;

    public void ai(boolean z) {
        this.KC = z;
    }

    public boolean kM() {
        return this.KD;
    }

    public void aj(boolean z) {
        this.KD = z;
    }

    public void bF(String str) {
        this.exception = str;
    }

    public void ad(int i) {
        this.JL = i;
    }

    public void kN() {
        this.exception = "";
    }

    public void bG(String str) {
        this.KE = str;
    }

    public String kO() {
        return this.KE;
    }

    public void ae(int i) {
        this.KF = i;
    }

    public void G(long j) {
        this.KG = j;
    }

    public String toString() {
        return "isFromNet_" + this.KC + "-statType_" + this.KF + "-dnsErr_" + this.exception + "-hasRetry_" + this.JL + "-cost_" + this.KG + "-ipIndex_" + this.JW + "-ipResult_" + this.KA;
    }

    public String kP() {
        return this.KA;
    }

    public void bH(String str) {
        this.KA = str;
    }

    public void aa(int i) {
        this.JW = i;
    }
}
