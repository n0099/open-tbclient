package com.baidu.ar.ability;
/* loaded from: classes10.dex */
public class c {
    private String bD;
    private boolean bE = false;
    private boolean bF = false;
    private boolean bG = false;
    private long mTimestamp;

    public String ab() {
        return this.bD;
    }

    public boolean ac() {
        return this.bE;
    }

    public boolean ad() {
        return this.bF;
    }

    public boolean ae() {
        return this.bG;
    }

    public void c(boolean z) {
        this.bE = z;
    }

    public void d(boolean z) {
        this.bF = z;
    }

    public void e(boolean z) {
        this.bG = z;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void r(String str) {
        this.bD = str;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
