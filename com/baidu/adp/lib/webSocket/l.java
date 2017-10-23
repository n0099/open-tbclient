package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int Ao;
    private int Ap;
    private boolean Aq;
    private boolean Ar;
    private int As;
    private int At;
    private boolean Au;
    private boolean Av;
    private String zA;

    public l() {
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

    public l(l lVar) {
        this.zA = null;
        this.Ao = lVar.Ao;
        this.Ap = lVar.Ap;
        this.Aq = lVar.Aq;
        this.Ar = lVar.Ar;
        this.As = lVar.As;
        this.At = lVar.At;
        this.Au = lVar.Au;
        this.Av = lVar.Av;
        this.zA = lVar.zA;
    }

    public boolean ik() {
        return this.Aq;
    }

    public int il() {
        return this.Ao;
    }

    public int im() {
        return this.Ap;
    }

    public boolean getTcpNoDelay() {
        return this.Ar;
    }

    public int in() {
        return this.As;
    }

    public int io() {
        return this.At;
    }

    public boolean ip() {
        return this.Au;
    }

    public boolean iq() {
        return this.Av;
    }

    public String ir() {
        return this.zA;
    }

    public void aV(String str) {
        this.zA = str;
    }
}
