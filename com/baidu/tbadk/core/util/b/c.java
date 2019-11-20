package com.baidu.tbadk.core.util.b;
/* loaded from: classes.dex */
public class c {
    private String ckD;
    private boolean ckE = false;
    private boolean ckF = false;
    private boolean ckG = false;
    private String ckH;
    private int ckI;
    private long ckJ;
    private String exception;

    public void em(boolean z) {
        this.ckE = z;
    }

    public boolean anc() {
        return this.ckF;
    }

    public void en(boolean z) {
        this.ckF = z;
    }

    public void oe(String str) {
        this.exception = str;
    }

    public void eo(boolean z) {
        this.ckG = z;
    }

    public void and() {
        this.exception = "";
    }

    public void og(String str) {
        this.ckH = str;
    }

    public String ane() {
        return this.ckH;
    }

    public void iw(int i) {
        this.ckI = i;
    }

    public void aW(long j) {
        this.ckJ = j;
    }

    public String toString() {
        return "isFromNet_" + this.ckE + "-statType_" + this.ckI + "-dnsErr_" + this.exception + "-hasRetry_" + this.ckG + "-cost_" + this.ckJ;
    }

    public String anf() {
        return this.ckD;
    }

    public void oh(String str) {
        this.ckD = str;
    }
}
