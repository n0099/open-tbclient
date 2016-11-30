package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private String ts;
    private int uf;
    private int ug;
    private boolean uh;
    private boolean ui;
    private int uj;
    private int uk;
    private boolean ul;
    private boolean um;

    public n() {
        this.ts = null;
        this.uf = 32768;
        this.ug = 131072;
        this.uh = false;
        this.ui = true;
        this.uj = 30000;
        this.uk = 30000;
        this.ul = true;
        this.um = true;
        this.ts = null;
    }

    public n(n nVar) {
        this.ts = null;
        this.uf = nVar.uf;
        this.ug = nVar.ug;
        this.uh = nVar.uh;
        this.ui = nVar.ui;
        this.uj = nVar.uj;
        this.uk = nVar.uk;
        this.ul = nVar.ul;
        this.um = nVar.um;
        this.ts = nVar.ts;
    }

    public boolean hq() {
        return this.uh;
    }

    public int hr() {
        return this.uf;
    }

    public int hs() {
        return this.ug;
    }

    public boolean getTcpNoDelay() {
        return this.ui;
    }

    public int ht() {
        return this.uj;
    }

    public int hu() {
        return this.uk;
    }

    public boolean hv() {
        return this.ul;
    }

    public boolean hw() {
        return this.um;
    }

    public String hx() {
        return this.ts;
    }

    public void aX(String str) {
        this.ts = str;
    }
}
