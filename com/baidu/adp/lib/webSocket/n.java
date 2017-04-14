package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private int AM;
    private int AN;
    private boolean AO;
    private boolean AP;
    private int AQ;
    private int AR;
    private boolean AS;
    private boolean AT;
    private String zY;

    public n() {
        this.zY = null;
        this.AM = 32768;
        this.AN = 131072;
        this.AO = false;
        this.AP = true;
        this.AQ = 30000;
        this.AR = 30000;
        this.AS = true;
        this.AT = true;
        this.zY = null;
    }

    public n(n nVar) {
        this.zY = null;
        this.AM = nVar.AM;
        this.AN = nVar.AN;
        this.AO = nVar.AO;
        this.AP = nVar.AP;
        this.AQ = nVar.AQ;
        this.AR = nVar.AR;
        this.AS = nVar.AS;
        this.AT = nVar.AT;
        this.zY = nVar.zY;
    }

    public boolean im() {
        return this.AO;
    }

    public int in() {
        return this.AM;
    }

    public int io() {
        return this.AN;
    }

    public boolean getTcpNoDelay() {
        return this.AP;
    }

    public int ip() {
        return this.AQ;
    }

    public int iq() {
        return this.AR;
    }

    public boolean ir() {
        return this.AS;
    }

    public boolean is() {
        return this.AT;
    }

    public String it() {
        return this.zY;
    }

    public void aL(String str) {
        this.zY = str;
    }
}
