package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private int NH;
    private String Oo;
    private String Or;
    private int Os;
    private long Ot;
    private String exception;
    private boolean Op = false;
    private boolean Oq = false;
    private int Ns = 0;

    public void aj(boolean z) {
        this.Op = z;
    }

    public boolean mg() {
        return this.Oq;
    }

    public void ak(boolean z) {
        this.Oq = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void au(int i) {
        this.Ns = i;
    }

    public void mh() {
        this.exception = "";
    }

    public void bN(String str) {
        this.Or = str;
    }

    public String mi() {
        return this.Or;
    }

    public void av(int i) {
        this.Os = i;
    }

    public void E(long j) {
        this.Ot = j;
    }

    public String toString() {
        return "isFromNet_" + this.Op + "-statType_" + this.Os + "-dnsErr_" + this.exception + "-hasRetry_" + this.Ns + "-cost_" + this.Ot + "-ipIndex_" + this.NH + "-ipResult_" + this.Oo;
    }

    public String mj() {
        return this.Oo;
    }

    public void bO(String str) {
        this.Oo = str;
    }

    public void ar(int i) {
        this.NH = i;
    }
}
