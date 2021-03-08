package com.baidu.swan.pms.c.d;
/* loaded from: classes3.dex */
public class c extends g {
    private String ewD;
    private long ewE;
    private long ewF;
    private String ewG;
    private String ewH;
    private int ewI;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.ewE = -1L;
        this.ewF = -1L;
        this.ewI = -1;
        this.ewD = str;
    }

    public c lX(int i) {
        this.ewI = i;
        return this;
    }

    public int bdp() {
        return this.ewI;
    }

    public c yk(String str) {
        this.ewG = str;
        return this;
    }

    public c dy(long j) {
        this.ewE = j;
        return this;
    }

    public c dz(long j) {
        this.ewF = j;
        return this;
    }

    public c yl(String str) {
        this.ewH = str;
        return this;
    }

    public c ym(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.ewD;
    }

    public long bdn() {
        return this.ewE;
    }

    public long bdo() {
        return this.ewF;
    }

    public String bdq() {
        return this.ewG;
    }

    public String bdr() {
        return this.ewH;
    }

    public String getPath() {
        return this.mPath;
    }
}
