package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private int Ao;
    private int Ap;
    private boolean Aq;
    private boolean Ar;
    private int As;
    private int At;
    private boolean Au;
    private boolean Av;
    private String zA;

    public n() {
        this.zA = null;
        this.Ao = 32768;
        this.Ap = 131072;
        this.Aq = false;
        this.Ar = true;
        this.As = 30000;
        this.At = 30000;
        this.Au = true;
        this.Av = true;
        this.zA = null;
    }

    public n(n nVar) {
        this.zA = null;
        this.Ao = nVar.Ao;
        this.Ap = nVar.Ap;
        this.Aq = nVar.Aq;
        this.Ar = nVar.Ar;
        this.As = nVar.As;
        this.At = nVar.At;
        this.Au = nVar.Au;
        this.Av = nVar.Av;
        this.zA = nVar.zA;
    }

    public boolean jN() {
        return this.Aq;
    }

    public int jO() {
        return this.Ao;
    }

    public int jP() {
        return this.Ap;
    }

    public boolean getTcpNoDelay() {
        return this.Ar;
    }

    public int jQ() {
        return this.As;
    }

    public int jR() {
        return this.At;
    }

    public boolean jS() {
        return this.Au;
    }

    public boolean jT() {
        return this.Av;
    }

    public String jU() {
        return this.zA;
    }

    public void aX(String str) {
        this.zA = str;
    }
}
