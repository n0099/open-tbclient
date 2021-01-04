package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private String MT;
    private String MW;
    private int MX;
    private long MY;
    private int Mn;
    private String exception;
    private boolean MU = false;
    private boolean MV = false;
    private int Mb = 0;

    public void aj(boolean z) {
        this.MU = z;
    }

    public boolean mh() {
        return this.MV;
    }

    public void ak(boolean z) {
        this.MV = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void au(int i) {
        this.Mb = i;
    }

    public void mi() {
        this.exception = "";
    }

    public void bJ(String str) {
        this.MW = str;
    }

    public String mj() {
        return this.MW;
    }

    public void av(int i) {
        this.MX = i;
    }

    public void E(long j) {
        this.MY = j;
    }

    public String toString() {
        return "isFromNet_" + this.MU + "-statType_" + this.MX + "-dnsErr_" + this.exception + "-hasRetry_" + this.Mb + "-cost_" + this.MY + "-ipIndex_" + this.Mn + "-ipResult_" + this.MT;
    }

    public String mk() {
        return this.MT;
    }

    public void bK(String str) {
        this.MT = str;
    }

    public void ar(int i) {
        this.Mn = i;
    }
}
