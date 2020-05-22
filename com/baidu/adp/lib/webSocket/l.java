package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int OW;
    private int OX;
    private boolean OY;
    private boolean OZ;
    private String Ok;
    private int Pa;
    private int Pb;
    private boolean Pc;
    private boolean Pd;

    public l() {
        this.Ok = null;
        this.OW = 32768;
        this.OX = 131072;
        this.OY = false;
        this.OZ = true;
        this.Pa = 30000;
        this.Pb = 30000;
        this.Pc = true;
        this.Pd = true;
        this.Ok = null;
    }

    public l(l lVar) {
        this.Ok = null;
        this.OW = lVar.OW;
        this.OX = lVar.OX;
        this.OY = lVar.OY;
        this.OZ = lVar.OZ;
        this.Pa = lVar.Pa;
        this.Pb = lVar.Pb;
        this.Pc = lVar.Pc;
        this.Pd = lVar.Pd;
        this.Ok = lVar.Ok;
    }

    public boolean mU() {
        return this.OY;
    }

    public int mV() {
        return this.OW;
    }

    public int mW() {
        return this.OX;
    }

    public boolean getTcpNoDelay() {
        return this.OZ;
    }

    public int mX() {
        return this.Pa;
    }

    public int mY() {
        return this.Pb;
    }

    public boolean mZ() {
        return this.Pc;
    }

    public boolean na() {
        return this.Pd;
    }

    public String nb() {
        return this.Ok;
    }

    public void cd(String str) {
        this.Ok = str;
    }
}
