package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int vO;
    private int vP;
    private boolean vQ;
    private boolean vR;
    private int vS;
    private int vT;
    private boolean vU;
    private boolean vV;
    private String vg;

    public l() {
        this.vg = null;
        this.vO = 32768;
        this.vP = 131072;
        this.vQ = false;
        this.vR = true;
        this.vS = 30000;
        this.vT = 30000;
        this.vU = true;
        this.vV = true;
        this.vg = null;
    }

    public l(l lVar) {
        this.vg = null;
        this.vO = lVar.vO;
        this.vP = lVar.vP;
        this.vQ = lVar.vQ;
        this.vR = lVar.vR;
        this.vS = lVar.vS;
        this.vT = lVar.vT;
        this.vU = lVar.vU;
        this.vV = lVar.vV;
        this.vg = lVar.vg;
    }

    public boolean ip() {
        return this.vQ;
    }

    public int iq() {
        return this.vO;
    }

    public int ir() {
        return this.vP;
    }

    public boolean getTcpNoDelay() {
        return this.vR;
    }

    public int is() {
        return this.vS;
    }

    public int it() {
        return this.vT;
    }

    public boolean iu() {
        return this.vU;
    }

    public boolean iv() {
        return this.vV;
    }

    public String iw() {
        return this.vg;
    }

    public void aN(String str) {
        this.vg = str;
    }
}
