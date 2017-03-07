package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private String Ay;
    private int Bl;
    private int Bm;
    private boolean Bn;
    private boolean Bo;
    private int Bp;
    private int Bq;
    private boolean Br;
    private boolean Bs;

    public n() {
        this.Ay = null;
        this.Bl = 32768;
        this.Bm = 131072;
        this.Bn = false;
        this.Bo = true;
        this.Bp = 30000;
        this.Bq = 30000;
        this.Br = true;
        this.Bs = true;
        this.Ay = null;
    }

    public n(n nVar) {
        this.Ay = null;
        this.Bl = nVar.Bl;
        this.Bm = nVar.Bm;
        this.Bn = nVar.Bn;
        this.Bo = nVar.Bo;
        this.Bp = nVar.Bp;
        this.Bq = nVar.Bq;
        this.Br = nVar.Br;
        this.Bs = nVar.Bs;
        this.Ay = nVar.Ay;
    }

    public boolean ii() {
        return this.Bn;
    }

    public int ij() {
        return this.Bl;
    }

    public int ik() {
        return this.Bm;
    }

    public boolean getTcpNoDelay() {
        return this.Bo;
    }

    public int il() {
        return this.Bp;
    }

    public int im() {
        return this.Bq;
    }

    public boolean in() {
        return this.Br;
    }

    public boolean io() {
        return this.Bs;
    }

    public String ip() {
        return this.Ay;
    }

    public void aQ(String str) {
        this.Ay = str;
    }
}
