package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private String qw;
    private int rj;
    private int rk;
    private boolean rl;
    private boolean rm;
    private int ro;
    private int rp;
    private boolean rq;
    private boolean rr;

    public n() {
        this.qw = null;
        this.rj = 32768;
        this.rk = 131072;
        this.rl = false;
        this.rm = true;
        this.ro = 30000;
        this.rp = 30000;
        this.rq = true;
        this.rr = true;
        this.qw = null;
    }

    public n(n nVar) {
        this.qw = null;
        this.rj = nVar.rj;
        this.rk = nVar.rk;
        this.rl = nVar.rl;
        this.rm = nVar.rm;
        this.ro = nVar.ro;
        this.rp = nVar.rp;
        this.rq = nVar.rq;
        this.rr = nVar.rr;
        this.qw = nVar.qw;
    }

    public boolean gw() {
        return this.rl;
    }

    public int gx() {
        return this.rj;
    }

    public int gy() {
        return this.rk;
    }

    public boolean getTcpNoDelay() {
        return this.rm;
    }

    public int gz() {
        return this.ro;
    }

    public int gA() {
        return this.rp;
    }

    public boolean gB() {
        return this.rq;
    }

    public boolean gC() {
        return this.rr;
    }

    public String gD() {
        return this.qw;
    }

    public void aV(String str) {
        this.qw = str;
    }
}
