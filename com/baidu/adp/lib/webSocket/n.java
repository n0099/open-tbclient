package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private int Ap;
    private int Aq;
    private boolean Ar;
    private boolean As;
    private int At;
    private int Au;
    private boolean Av;
    private boolean Aw;
    private String zB;

    public n() {
        this.zB = null;
        this.Ap = 32768;
        this.Aq = 131072;
        this.Ar = false;
        this.As = true;
        this.At = 30000;
        this.Au = 30000;
        this.Av = true;
        this.Aw = true;
        this.zB = null;
    }

    public n(n nVar) {
        this.zB = null;
        this.Ap = nVar.Ap;
        this.Aq = nVar.Aq;
        this.Ar = nVar.Ar;
        this.As = nVar.As;
        this.At = nVar.At;
        this.Au = nVar.Au;
        this.Av = nVar.Av;
        this.Aw = nVar.Aw;
        this.zB = nVar.zB;
    }

    public boolean jP() {
        return this.Ar;
    }

    public int jQ() {
        return this.Ap;
    }

    public int jR() {
        return this.Aq;
    }

    public boolean getTcpNoDelay() {
        return this.As;
    }

    public int jS() {
        return this.At;
    }

    public int jT() {
        return this.Au;
    }

    public boolean jU() {
        return this.Av;
    }

    public boolean jV() {
        return this.Aw;
    }

    public String jW() {
        return this.zB;
    }

    public void aW(String str) {
        this.zB = str;
    }
}
