package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private int AX;
    private int AY;
    private boolean AZ;
    private String Ak;
    private boolean Ba;
    private int Bb;
    private int Bc;
    private boolean Bd;
    private boolean Be;

    public n() {
        this.Ak = null;
        this.AX = 32768;
        this.AY = 131072;
        this.AZ = false;
        this.Ba = true;
        this.Bb = 30000;
        this.Bc = 30000;
        this.Bd = true;
        this.Be = true;
        this.Ak = null;
    }

    public n(n nVar) {
        this.Ak = null;
        this.AX = nVar.AX;
        this.AY = nVar.AY;
        this.AZ = nVar.AZ;
        this.Ba = nVar.Ba;
        this.Bb = nVar.Bb;
        this.Bc = nVar.Bc;
        this.Bd = nVar.Bd;
        this.Be = nVar.Be;
        this.Ak = nVar.Ak;
    }

    public boolean kh() {
        return this.AZ;
    }

    public int ki() {
        return this.AX;
    }

    public int kj() {
        return this.AY;
    }

    public boolean getTcpNoDelay() {
        return this.Ba;
    }

    public int kk() {
        return this.Bb;
    }

    public int kl() {
        return this.Bc;
    }

    public boolean km() {
        return this.Bd;
    }

    public boolean kn() {
        return this.Be;
    }

    public String ko() {
        return this.Ak;
    }

    public void bc(String str) {
        this.Ak = str;
    }
}
