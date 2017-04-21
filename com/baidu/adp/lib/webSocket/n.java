package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private int AP;
    private int AQ;
    private boolean AR;
    private boolean AS;
    private int AT;
    private int AU;
    private boolean AV;
    private boolean AW;
    private String Ab;

    public n() {
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

    public n(n nVar) {
        this.Ab = null;
        this.AP = nVar.AP;
        this.AQ = nVar.AQ;
        this.AR = nVar.AR;
        this.AS = nVar.AS;
        this.AT = nVar.AT;
        this.AU = nVar.AU;
        this.AV = nVar.AV;
        this.AW = nVar.AW;
        this.Ab = nVar.Ab;
    }

    public boolean in() {
        return this.AR;
    }

    public int io() {
        return this.AP;
    }

    public int ip() {
        return this.AQ;
    }

    public boolean getTcpNoDelay() {
        return this.AS;
    }

    public int iq() {
        return this.AT;
    }

    public int ir() {
        return this.AU;
    }

    public boolean is() {
        return this.AV;
    }

    public boolean it() {
        return this.AW;
    }

    public String iu() {
        return this.Ab;
    }

    public void aL(String str) {
        this.Ab = str;
    }
}
