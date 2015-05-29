package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class al {
    private int AC;
    private int AD;
    private boolean AE;
    private boolean AF;
    private int AG;
    private int AH;
    private boolean AI;
    private boolean AJ;
    private String zQ;

    public al() {
        this.zQ = null;
        this.AC = 32768;
        this.AD = 131072;
        this.AE = false;
        this.AF = true;
        this.AG = 30000;
        this.AH = 30000;
        this.AI = true;
        this.AJ = true;
        this.zQ = null;
    }

    public al(al alVar) {
        this.zQ = null;
        this.AC = alVar.AC;
        this.AD = alVar.AD;
        this.AE = alVar.AE;
        this.AF = alVar.AF;
        this.AG = alVar.AG;
        this.AH = alVar.AH;
        this.AI = alVar.AI;
        this.AJ = alVar.AJ;
        this.zQ = alVar.zQ;
    }

    public boolean jX() {
        return this.AE;
    }

    public int jY() {
        return this.AC;
    }

    public int jZ() {
        return this.AD;
    }

    public boolean getTcpNoDelay() {
        return this.AF;
    }

    public int ka() {
        return this.AG;
    }

    public int kb() {
        return this.AH;
    }

    public boolean kc() {
        return this.AI;
    }

    public boolean kd() {
        return this.AJ;
    }

    public String ke() {
        return this.zQ;
    }

    public void be(String str) {
        this.zQ = str;
    }
}
