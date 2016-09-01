package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private String tr;
    private int ue;
    private int uf;
    private boolean ug;
    private boolean uh;
    private int ui;
    private int uj;
    private boolean uk;
    private boolean ul;

    public n() {
        this.tr = null;
        this.ue = 32768;
        this.uf = 131072;
        this.ug = false;
        this.uh = true;
        this.ui = 30000;
        this.uj = 30000;
        this.uk = true;
        this.ul = true;
        this.tr = null;
    }

    public n(n nVar) {
        this.tr = null;
        this.ue = nVar.ue;
        this.uf = nVar.uf;
        this.ug = nVar.ug;
        this.uh = nVar.uh;
        this.ui = nVar.ui;
        this.uj = nVar.uj;
        this.uk = nVar.uk;
        this.ul = nVar.ul;
        this.tr = nVar.tr;
    }

    public boolean hq() {
        return this.ug;
    }

    public int hr() {
        return this.ue;
    }

    public int hs() {
        return this.uf;
    }

    public boolean getTcpNoDelay() {
        return this.uh;
    }

    public int ht() {
        return this.ui;
    }

    public int hu() {
        return this.uj;
    }

    public boolean hv() {
        return this.uk;
    }

    public boolean hw() {
        return this.ul;
    }

    public String hx() {
        return this.tr;
    }

    public void aX(String str) {
        this.tr = str;
    }
}
