package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int AP;
    private int AQ;
    private boolean AR;
    private boolean AS;
    private int AT;
    private int AU;
    private boolean AV;
    private boolean AW;
    private String Ab;

    public l() {
        this.Ab = null;
        this.AP = 32768;
        this.AQ = 131072;
        this.AR = false;
        this.AS = true;
        this.AT = 30000;
        this.AU = 30000;
        this.AV = true;
        this.AW = true;
        this.Ab = null;
    }

    public l(l lVar) {
        this.Ab = null;
        this.AP = lVar.AP;
        this.AQ = lVar.AQ;
        this.AR = lVar.AR;
        this.AS = lVar.AS;
        this.AT = lVar.AT;
        this.AU = lVar.AU;
        this.AV = lVar.AV;
        this.AW = lVar.AW;
        this.Ab = lVar.Ab;
    }

    public boolean ij() {
        return this.AR;
    }

    public int ik() {
        return this.AP;
    }

    public int il() {
        return this.AQ;
    }

    public boolean getTcpNoDelay() {
        return this.AS;
    }

    public int im() {
        return this.AT;
    }

    public int in() {
        return this.AU;
    }

    public boolean io() {
        return this.AV;
    }

    public boolean ip() {
        return this.AW;
    }

    public String iq() {
        return this.Ab;
    }

    public void aS(String str) {
        this.Ab = str;
    }
}
