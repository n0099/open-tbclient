package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private String MR;
    private String MU;
    private int MV;
    private long MW;
    private int Ml;
    private String exception;
    private boolean MS = false;
    private boolean MT = false;
    private int LZ = 0;

    public void aj(boolean z) {
        this.MS = z;
    }

    public boolean mh() {
        return this.MT;
    }

    public void ak(boolean z) {
        this.MT = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void au(int i) {
        this.LZ = i;
    }

    public void mi() {
        this.exception = "";
    }

    public void bJ(String str) {
        this.MU = str;
    }

    public String mj() {
        return this.MU;
    }

    public void av(int i) {
        this.MV = i;
    }

    public void E(long j) {
        this.MW = j;
    }

    public String toString() {
        return "isFromNet_" + this.MS + "-statType_" + this.MV + "-dnsErr_" + this.exception + "-hasRetry_" + this.LZ + "-cost_" + this.MW + "-ipIndex_" + this.Ml + "-ipResult_" + this.MR;
    }

    public String mk() {
        return this.MR;
    }

    public void bK(String str) {
        this.MR = str;
    }

    public void ar(int i) {
        this.Ml = i;
    }
}
