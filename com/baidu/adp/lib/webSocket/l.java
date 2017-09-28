package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int An;
    private int Ao;
    private boolean Ap;
    private boolean Aq;
    private int Ar;
    private int As;
    private boolean At;
    private boolean Au;
    private String zz;

    public l() {
        this.zz = null;
        this.An = 32768;
        this.Ao = 131072;
        this.Ap = false;
        this.Aq = true;
        this.Ar = 30000;
        this.As = 30000;
        this.At = true;
        this.Au = true;
        this.zz = null;
    }

    public l(l lVar) {
        this.zz = null;
        this.An = lVar.An;
        this.Ao = lVar.Ao;
        this.Ap = lVar.Ap;
        this.Aq = lVar.Aq;
        this.Ar = lVar.Ar;
        this.As = lVar.As;
        this.At = lVar.At;
        this.Au = lVar.Au;
        this.zz = lVar.zz;
    }

    public boolean ik() {
        return this.Ap;
    }

    public int il() {
        return this.An;
    }

    public int im() {
        return this.Ao;
    }

    public boolean getTcpNoDelay() {
        return this.Aq;
    }

    public int in() {
        return this.Ar;
    }

    public int io() {
        return this.As;
    }

    public boolean ip() {
        return this.At;
    }

    public boolean iq() {
        return this.Au;
    }

    public String ir() {
        return this.zz;
    }

    public void aV(String str) {
        this.zz = str;
    }
}
