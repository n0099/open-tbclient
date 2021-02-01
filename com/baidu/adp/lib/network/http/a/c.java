package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private String MP;
    private String MS;
    private int MT;
    private long MU;
    private int Mj;
    private String exception;
    private boolean MQ = false;
    private boolean MR = false;
    private int LX = 0;

    public void aj(boolean z) {
        this.MQ = z;
    }

    public boolean mg() {
        return this.MR;
    }

    public void ak(boolean z) {
        this.MR = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void au(int i) {
        this.LX = i;
    }

    public void mh() {
        this.exception = "";
    }

    public void bJ(String str) {
        this.MS = str;
    }

    public String mi() {
        return this.MS;
    }

    public void av(int i) {
        this.MT = i;
    }

    public void E(long j) {
        this.MU = j;
    }

    public String toString() {
        return "isFromNet_" + this.MQ + "-statType_" + this.MT + "-dnsErr_" + this.exception + "-hasRetry_" + this.LX + "-cost_" + this.MU + "-ipIndex_" + this.Mj + "-ipResult_" + this.MP;
    }

    public String mj() {
        return this.MP;
    }

    public void bK(String str) {
        this.MP = str;
    }

    public void ar(int i) {
        this.Mj = i;
    }
}
