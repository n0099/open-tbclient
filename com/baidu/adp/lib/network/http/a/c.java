package com.baidu.adp.lib.network.http.a;
/* loaded from: classes.dex */
public class c {
    private int MQ;
    private String Nt;
    private String Nw;
    private int Nx;
    private long Ny;
    private String exception;
    private boolean Nu = false;
    private boolean Nv = false;
    private int MC = 0;

    public void ak(boolean z) {
        this.Nu = z;
    }

    public boolean mJ() {
        return this.Nv;
    }

    public void al(boolean z) {
        this.Nv = z;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void au(int i) {
        this.MC = i;
    }

    public void mK() {
        this.exception = "";
    }

    public void bP(String str) {
        this.Nw = str;
    }

    public String mL() {
        return this.Nw;
    }

    public void av(int i) {
        this.Nx = i;
    }

    public void E(long j) {
        this.Ny = j;
    }

    public String toString() {
        return "isFromNet_" + this.Nu + "-statType_" + this.Nx + "-dnsErr_" + this.exception + "-hasRetry_" + this.MC + "-cost_" + this.Ny + "-ipIndex_" + this.MQ + "-ipResult_" + this.Nt;
    }

    public String mM() {
        return this.Nt;
    }

    public void bQ(String str) {
        this.Nt = str;
    }

    public void ar(int i) {
        this.MQ = i;
    }
}
