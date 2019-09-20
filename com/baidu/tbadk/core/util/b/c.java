package com.baidu.tbadk.core.util.b;
/* loaded from: classes.dex */
public class c {
    private String Az;
    private String bWo;
    private boolean bWp = false;
    private boolean bWq = false;
    private boolean bWr = false;
    private String bWs;
    private int bWt;
    private long bWu;

    public void eh(boolean z) {
        this.bWp = z;
    }

    public boolean aka() {
        return this.bWq;
    }

    public void ei(boolean z) {
        this.bWq = z;
    }

    public void oD(String str) {
        this.Az = str;
    }

    public void ej(boolean z) {
        this.bWr = z;
    }

    public void akb() {
        this.Az = "";
    }

    public void oE(String str) {
        this.bWs = str;
    }

    public String akc() {
        return this.bWs;
    }

    public void iy(int i) {
        this.bWt = i;
    }

    public void bf(long j) {
        this.bWu = j;
    }

    public String toString() {
        return "isFromNet_" + this.bWp + "-statType_" + this.bWt + "-dnsErr_" + this.Az + "-hasRetry_" + this.bWr + "-cost_" + this.bWu;
    }

    public String akd() {
        return this.bWo;
    }

    public void oF(String str) {
        this.bWo = str;
    }
}
