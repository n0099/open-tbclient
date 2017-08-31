package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int Al;
    private int Am;
    private boolean An;
    private boolean Ao;
    private int Ap;
    private int Aq;
    private boolean Ar;
    private boolean As;
    private String zx;

    public l() {
        this.zx = null;
        this.Al = 32768;
        this.Am = 131072;
        this.An = false;
        this.Ao = true;
        this.Ap = 30000;
        this.Aq = 30000;
        this.Ar = true;
        this.As = true;
        this.zx = null;
    }

    public l(l lVar) {
        this.zx = null;
        this.Al = lVar.Al;
        this.Am = lVar.Am;
        this.An = lVar.An;
        this.Ao = lVar.Ao;
        this.Ap = lVar.Ap;
        this.Aq = lVar.Aq;
        this.Ar = lVar.Ar;
        this.As = lVar.As;
        this.zx = lVar.zx;
    }

    public boolean il() {
        return this.An;
    }

    public int im() {
        return this.Al;
    }

    public int in() {
        return this.Am;
    }

    public boolean getTcpNoDelay() {
        return this.Ao;
    }

    public int io() {
        return this.Ap;
    }

    public int ip() {
        return this.Aq;
    }

    public boolean iq() {
        return this.Ar;
    }

    public boolean ir() {
        return this.As;
    }

    public String is() {
        return this.zx;
    }

    public void aV(String str) {
        this.zx = str;
    }
}
