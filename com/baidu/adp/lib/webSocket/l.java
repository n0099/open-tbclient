package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String Ps;
    private int Qh;
    private int Qi;
    private boolean Qj;
    private boolean Qk;
    private int Ql;
    private int Qm;
    private boolean Qn;
    private boolean Qo;

    public l() {
        this.Ps = null;
        this.Qh = 32768;
        this.Qi = 131072;
        this.Qj = false;
        this.Qk = true;
        this.Ql = 30000;
        this.Qm = 30000;
        this.Qn = true;
        this.Qo = true;
        this.Ps = null;
    }

    public l(l lVar) {
        this.Ps = null;
        this.Qh = lVar.Qh;
        this.Qi = lVar.Qi;
        this.Qj = lVar.Qj;
        this.Qk = lVar.Qk;
        this.Ql = lVar.Ql;
        this.Qm = lVar.Qm;
        this.Qn = lVar.Qn;
        this.Qo = lVar.Qo;
        this.Ps = lVar.Ps;
    }

    public boolean oL() {
        return this.Qj;
    }

    public int oM() {
        return this.Qh;
    }

    public int oN() {
        return this.Qi;
    }

    public boolean getTcpNoDelay() {
        return this.Qk;
    }

    public int oO() {
        return this.Ql;
    }

    public int oP() {
        return this.Qm;
    }

    public boolean oQ() {
        return this.Qn;
    }

    public boolean oR() {
        return this.Qo;
    }

    public String oS() {
        return this.Ps;
    }

    public void ci(String str) {
        this.Ps = str;
    }
}
