package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private int JZ;
    private String KE;
    private String KH;
    private int KI;
    private long KJ;
    private String exception;
    private boolean KF = false;
    private boolean KG = false;
    private int JO = 0;

    public void ai(boolean z) {
        this.KF = z;
    }

    public boolean kM() {
        return this.KG;
    }

    public void aj(boolean z) {
        this.KG = z;
    }

    public void bF(String str) {
        this.exception = str;
    }

    public void ad(int i) {
        this.JO = i;
    }

    public void kN() {
        this.exception = "";
    }

    public void bG(String str) {
        this.KH = str;
    }

    public String kO() {
        return this.KH;
    }

    public void ae(int i) {
        this.KI = i;
    }

    public void G(long j) {
        this.KJ = j;
    }

    public String toString() {
        return "isFromNet_" + this.KF + "-statType_" + this.KI + "-dnsErr_" + this.exception + "-hasRetry_" + this.JO + "-cost_" + this.KJ + "-ipIndex_" + this.JZ + "-ipResult_" + this.KE;
    }

    public String kP() {
        return this.KE;
    }

    public void bH(String str) {
        this.KE = str;
    }

    public void aa(int i) {
        this.JZ = i;
    }
}
