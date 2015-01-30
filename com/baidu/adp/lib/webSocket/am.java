package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class am {
    private String ps;
    private int qd;
    private int qe;
    private boolean qf;
    private boolean qg;
    private int qh;
    private int qi;
    private boolean qj;
    private boolean qk;

    public am() {
        this.ps = null;
        this.qd = 131072;
        this.qe = 131072;
        this.qf = false;
        this.qg = true;
        this.qh = 30000;
        this.qi = 30000;
        this.qj = true;
        this.qk = true;
        this.ps = null;
    }

    public am(am amVar) {
        this.ps = null;
        this.qd = amVar.qd;
        this.qe = amVar.qe;
        this.qf = amVar.qf;
        this.qg = amVar.qg;
        this.qh = amVar.qh;
        this.qi = amVar.qi;
        this.qj = amVar.qj;
        this.qk = amVar.qk;
        this.ps = amVar.ps;
    }

    public boolean gk() {
        return this.qf;
    }

    public int gl() {
        return this.qd;
    }

    public int gm() {
        return this.qe;
    }

    public boolean getTcpNoDelay() {
        return this.qg;
    }

    public int gn() {
        return this.qh;
    }

    public int go() {
        return this.qi;
    }

    public boolean gp() {
        return this.qj;
    }

    public boolean gq() {
        return this.qk;
    }

    public String gr() {
        return this.ps;
    }

    public void aM(String str) {
        this.ps = str;
    }
}
