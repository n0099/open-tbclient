package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private int KM;
    private String Lp;
    private String Ls;
    private int Lt;
    private long Lu;
    private String exception;
    private boolean Lq = false;
    private boolean Lr = false;
    private int Kz = 0;

    public void al(boolean z) {
        this.Lq = z;
    }

    public boolean le() {
        return this.Lr;
    }

    public void am(boolean z) {
        this.Lr = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void ak(int i) {
        this.Kz = i;
    }

    public void lf() {
        this.exception = "";
    }

    public void bH(String str) {
        this.Ls = str;
    }

    public String lg() {
        return this.Ls;
    }

    public void al(int i) {
        this.Lt = i;
    }

    public void G(long j) {
        this.Lu = j;
    }

    public String toString() {
        return "isFromNet_" + this.Lq + "-statType_" + this.Lt + "-dnsErr_" + this.exception + "-hasRetry_" + this.Kz + "-cost_" + this.Lu + "-ipIndex_" + this.KM + "-ipResult_" + this.Lp;
    }

    public String lh() {
        return this.Lp;
    }

    public void bI(String str) {
        this.Lp = str;
    }

    public void ah(int i) {
        this.KM = i;
    }
}
