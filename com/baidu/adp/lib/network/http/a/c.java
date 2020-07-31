package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private int KM;
    private String Lo;
    private String Lr;
    private int Ls;
    private long Lt;
    private String exception;
    private boolean Lp = false;
    private boolean Lq = false;
    private int Kz = 0;

    public void al(boolean z) {
        this.Lp = z;
    }

    public boolean le() {
        return this.Lq;
    }

    public void am(boolean z) {
        this.Lq = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void am(int i) {
        this.Kz = i;
    }

    public void lf() {
        this.exception = "";
    }

    public void bF(String str) {
        this.Lr = str;
    }

    public String lg() {
        return this.Lr;
    }

    public void an(int i) {
        this.Ls = i;
    }

    public void G(long j) {
        this.Lt = j;
    }

    public String toString() {
        return "isFromNet_" + this.Lp + "-statType_" + this.Ls + "-dnsErr_" + this.exception + "-hasRetry_" + this.Kz + "-cost_" + this.Lt + "-ipIndex_" + this.KM + "-ipResult_" + this.Lo;
    }

    public String lh() {
        return this.Lo;
    }

    public void bG(String str) {
        this.Lo = str;
    }

    public void aj(int i) {
        this.KM = i;
    }
}
