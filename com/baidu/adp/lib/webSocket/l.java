package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String NY;
    private int OI;
    private int OJ;
    private boolean OL;
    private boolean OM;
    private int OO;
    private int OP;
    private boolean OQ;
    private boolean OR;

    public l() {
        this.NY = null;
        this.OI = 32768;
        this.OJ = 131072;
        this.OL = false;
        this.OM = true;
        this.OO = 30000;
        this.OP = 30000;
        this.OQ = true;
        this.OR = true;
        this.NY = null;
    }

    public l(l lVar) {
        this.NY = null;
        this.OI = lVar.OI;
        this.OJ = lVar.OJ;
        this.OL = lVar.OL;
        this.OM = lVar.OM;
        this.OO = lVar.OO;
        this.OP = lVar.OP;
        this.OQ = lVar.OQ;
        this.OR = lVar.OR;
        this.NY = lVar.NY;
    }

    public boolean mS() {
        return this.OL;
    }

    public int mT() {
        return this.OI;
    }

    public int mU() {
        return this.OJ;
    }

    public boolean getTcpNoDelay() {
        return this.OM;
    }

    public int mV() {
        return this.OO;
    }

    public int mW() {
        return this.OP;
    }

    public boolean mX() {
        return this.OQ;
    }

    public boolean mY() {
        return this.OR;
    }

    public String mZ() {
        return this.NY;
    }

    public void cc(String str) {
        this.NY = str;
    }
}
