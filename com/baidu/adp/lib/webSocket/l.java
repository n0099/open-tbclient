package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int OO;
    private int OP;
    private boolean OQ;
    private boolean OR;
    private int OT;
    private int OU;
    private boolean OV;
    private boolean OW;
    private String Oc;

    public l() {
        this.Oc = null;
        this.OO = 32768;
        this.OP = 131072;
        this.OQ = false;
        this.OR = true;
        this.OT = 30000;
        this.OU = 30000;
        this.OV = true;
        this.OW = true;
        this.Oc = null;
    }

    public l(l lVar) {
        this.Oc = null;
        this.OO = lVar.OO;
        this.OP = lVar.OP;
        this.OQ = lVar.OQ;
        this.OR = lVar.OR;
        this.OT = lVar.OT;
        this.OU = lVar.OU;
        this.OV = lVar.OV;
        this.OW = lVar.OW;
        this.Oc = lVar.Oc;
    }

    public boolean mS() {
        return this.OQ;
    }

    public int mT() {
        return this.OO;
    }

    public int mU() {
        return this.OP;
    }

    public boolean getTcpNoDelay() {
        return this.OR;
    }

    public int mV() {
        return this.OT;
    }

    public int mW() {
        return this.OU;
    }

    public boolean mX() {
        return this.OV;
    }

    public boolean mY() {
        return this.OW;
    }

    public String mZ() {
        return this.Oc;
    }

    public void cc(String str) {
        this.Oc = str;
    }
}
