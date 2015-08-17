package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private int Aq;
    private int Ar;
    private boolean As;
    private boolean At;
    private int Au;
    private int Av;
    private boolean Aw;
    private boolean Ax;
    private String zC;

    public n() {
        this.zC = null;
        this.Aq = 32768;
        this.Ar = 131072;
        this.As = false;
        this.At = true;
        this.Au = 30000;
        this.Av = 30000;
        this.Aw = true;
        this.Ax = true;
        this.zC = null;
    }

    public n(n nVar) {
        this.zC = null;
        this.Aq = nVar.Aq;
        this.Ar = nVar.Ar;
        this.As = nVar.As;
        this.At = nVar.At;
        this.Au = nVar.Au;
        this.Av = nVar.Av;
        this.Aw = nVar.Aw;
        this.Ax = nVar.Ax;
        this.zC = nVar.zC;
    }

    public boolean jQ() {
        return this.As;
    }

    public int jR() {
        return this.Aq;
    }

    public int jS() {
        return this.Ar;
    }

    public boolean getTcpNoDelay() {
        return this.At;
    }

    public int jT() {
        return this.Au;
    }

    public int jU() {
        return this.Av;
    }

    public boolean jV() {
        return this.Aw;
    }

    public boolean jW() {
        return this.Ax;
    }

    public String jX() {
        return this.zC;
    }

    public void aX(String str) {
        this.zC = str;
    }
}
