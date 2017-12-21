package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int Am;
    private int An;
    private boolean Ao;
    private boolean Ap;
    private int Aq;
    private int Ar;
    private boolean As;
    private boolean At;
    private String zy;

    public l() {
        this.zy = null;
        this.Am = 32768;
        this.An = 131072;
        this.Ao = false;
        this.Ap = true;
        this.Aq = 30000;
        this.Ar = 30000;
        this.As = true;
        this.At = true;
        this.zy = null;
    }

    public l(l lVar) {
        this.zy = null;
        this.Am = lVar.Am;
        this.An = lVar.An;
        this.Ao = lVar.Ao;
        this.Ap = lVar.Ap;
        this.Aq = lVar.Aq;
        this.Ar = lVar.Ar;
        this.As = lVar.As;
        this.At = lVar.At;
        this.zy = lVar.zy;
    }

    public boolean ik() {
        return this.Ao;
    }

    public int il() {
        return this.Am;
    }

    public int im() {
        return this.An;
    }

    public boolean getTcpNoDelay() {
        return this.Ap;
    }

    public int in() {
        return this.Aq;
    }

    public int io() {
        return this.Ar;
    }

    public boolean ip() {
        return this.As;
    }

    public boolean iq() {
        return this.At;
    }

    public String ir() {
        return this.zy;
    }

    public void aV(String str) {
        this.zy = str;
    }
}
