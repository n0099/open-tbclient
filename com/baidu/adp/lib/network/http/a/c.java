package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private String KP;
    private String KS;
    private int KT;
    private long KU;
    private int Kl;
    private String exception;
    private boolean KQ = false;
    private boolean KR = false;
    private int JZ = 0;

    public void ak(boolean z) {
        this.KQ = z;
    }

    public boolean kO() {
        return this.KR;
    }

    public void al(boolean z) {
        this.KR = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void ae(int i) {
        this.JZ = i;
    }

    public void kP() {
        this.exception = "";
    }

    public void bG(String str) {
        this.KS = str;
    }

    public String kQ() {
        return this.KS;
    }

    public void af(int i) {
        this.KT = i;
    }

    public void G(long j) {
        this.KU = j;
    }

    public String toString() {
        return "isFromNet_" + this.KQ + "-statType_" + this.KT + "-dnsErr_" + this.exception + "-hasRetry_" + this.JZ + "-cost_" + this.KU + "-ipIndex_" + this.Kl + "-ipResult_" + this.KP;
    }

    public String kR() {
        return this.KP;
    }

    public void bH(String str) {
        this.KP = str;
    }

    public void ab(int i) {
        this.Kl = i;
    }
}
