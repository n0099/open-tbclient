package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class al {
    private int AO;
    private int AP;
    private boolean AQ;
    private boolean AR;
    private int AS;
    private int AT;
    private boolean AU;
    private boolean AV;
    private String Ab;

    public al() {
        this.Ab = null;
        this.AO = 32768;
        this.AP = 131072;
        this.AQ = false;
        this.AR = true;
        this.AS = 30000;
        this.AT = 30000;
        this.AU = true;
        this.AV = true;
        this.Ab = null;
    }

    public al(al alVar) {
        this.Ab = null;
        this.AO = alVar.AO;
        this.AP = alVar.AP;
        this.AQ = alVar.AQ;
        this.AR = alVar.AR;
        this.AS = alVar.AS;
        this.AT = alVar.AT;
        this.AU = alVar.AU;
        this.AV = alVar.AV;
        this.Ab = alVar.Ab;
    }

    public boolean jG() {
        return this.AQ;
    }

    public int jH() {
        return this.AO;
    }

    public int jI() {
        return this.AP;
    }

    public boolean getTcpNoDelay() {
        return this.AR;
    }

    public int jJ() {
        return this.AS;
    }

    public int jK() {
        return this.AT;
    }

    public boolean jL() {
        return this.AU;
    }

    public boolean jM() {
        return this.AV;
    }

    public String jN() {
        return this.Ab;
    }

    public void aU(String str) {
        this.Ab = str;
    }
}
