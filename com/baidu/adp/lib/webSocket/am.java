package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class am {
    private int pY;
    private int pZ;
    private String pl;
    private boolean qa;
    private boolean qb;
    private int qc;
    private int qd;
    private boolean qe;
    private boolean qf;

    public am() {
        this.pl = null;
        this.pY = 131072;
        this.pZ = 131072;
        this.qa = false;
        this.qb = true;
        this.qc = 30000;
        this.qd = 30000;
        this.qe = true;
        this.qf = true;
        this.pl = null;
    }

    public am(am amVar) {
        this.pl = null;
        this.pY = amVar.pY;
        this.pZ = amVar.pZ;
        this.qa = amVar.qa;
        this.qb = amVar.qb;
        this.qc = amVar.qc;
        this.qd = amVar.qd;
        this.qe = amVar.qe;
        this.qf = amVar.qf;
        this.pl = amVar.pl;
    }

    public boolean gl() {
        return this.qa;
    }

    public int gm() {
        return this.pY;
    }

    public int gn() {
        return this.pZ;
    }

    public boolean getTcpNoDelay() {
        return this.qb;
    }

    public int go() {
        return this.qc;
    }

    public int gp() {
        return this.qd;
    }

    public boolean gq() {
        return this.qe;
    }

    public boolean gr() {
        return this.qf;
    }

    public String gs() {
        return this.pl;
    }

    public void aM(String str) {
        this.pl = str;
    }
}
