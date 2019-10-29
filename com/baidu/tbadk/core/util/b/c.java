package com.baidu.tbadk.core.util.b;
/* loaded from: classes.dex */
public class c {
    private long clA;
    private String clu;
    private boolean clv = false;
    private boolean clw = false;
    private boolean clx = false;
    private String cly;
    private int clz;
    private String exception;

    public void em(boolean z) {
        this.clv = z;
    }

    public boolean ane() {
        return this.clw;
    }

    public void en(boolean z) {
        this.clw = z;
    }

    public void oe(String str) {
        this.exception = str;
    }

    public void eo(boolean z) {
        this.clx = z;
    }

    public void anf() {
        this.exception = "";
    }

    public void og(String str) {
        this.cly = str;
    }

    public String ang() {
        return this.cly;
    }

    public void ix(int i) {
        this.clz = i;
    }

    public void aX(long j) {
        this.clA = j;
    }

    public String toString() {
        return "isFromNet_" + this.clv + "-statType_" + this.clz + "-dnsErr_" + this.exception + "-hasRetry_" + this.clx + "-cost_" + this.clA;
    }

    public String anh() {
        return this.clu;
    }

    public void oh(String str) {
        this.clu = str;
    }
}
