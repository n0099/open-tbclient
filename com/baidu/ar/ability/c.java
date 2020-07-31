package com.baidu.ar.ability;
/* loaded from: classes11.dex */
public class c {
    private String bJ;
    private boolean bK = false;
    private boolean bL = false;
    private boolean bM = false;
    private long mTimestamp;

    public String Z() {
        return this.bJ;
    }

    public boolean aa() {
        return this.bK;
    }

    public boolean ab() {
        return this.bL;
    }

    public boolean ac() {
        return this.bM;
    }

    public void c(boolean z) {
        this.bK = z;
    }

    public void d(boolean z) {
        this.bL = z;
    }

    public void e(boolean z) {
        this.bM = z;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void o(String str) {
        this.bJ = str;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
