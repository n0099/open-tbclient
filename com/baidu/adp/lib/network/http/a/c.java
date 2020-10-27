package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private int LV;
    private String MC;
    private int MD;
    private long ME;
    private String My;
    private String exception;
    private boolean Mz = false;
    private boolean MA = false;
    private int LD = 0;

    public void am(boolean z) {
        this.Mz = z;
    }

    public boolean mJ() {
        return this.MA;
    }

    public void an(boolean z) {
        this.MA = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void ar(int i) {
        this.LD = i;
    }

    public void mK() {
        this.exception = "";
    }

    public void bM(String str) {
        this.MC = str;
    }

    public String mL() {
        return this.MC;
    }

    public void as(int i) {
        this.MD = i;
    }

    public void G(long j) {
        this.ME = j;
    }

    public String toString() {
        return "isFromNet_" + this.Mz + "-statType_" + this.MD + "-dnsErr_" + this.exception + "-hasRetry_" + this.LD + "-cost_" + this.ME + "-ipIndex_" + this.LV + "-ipResult_" + this.My;
    }

    public String mM() {
        return this.My;
    }

    public void bN(String str) {
        this.My = str;
    }

    public void ao(int i) {
        this.LV = i;
    }
}
