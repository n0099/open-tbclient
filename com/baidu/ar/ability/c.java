package com.baidu.ar.ability;
/* loaded from: classes3.dex */
public class c {
    private String bx;
    private long mTimestamp;
    private boolean by = false;
    private boolean bz = false;
    private boolean bA = false;

    public String L() {
        return this.bx;
    }

    public boolean M() {
        return this.by;
    }

    public boolean N() {
        return this.bz;
    }

    public boolean O() {
        return this.bA;
    }

    public void c(boolean z) {
        this.by = z;
    }

    public void d(boolean z) {
        this.bz = z;
    }

    public void e(boolean z) {
        this.bA = z;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void o(String str) {
        this.bx = str;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
