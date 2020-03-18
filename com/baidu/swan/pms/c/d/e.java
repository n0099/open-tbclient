package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class e extends f {
    private String cCl;
    private int cCm;
    private String cCo;
    private String cCp;
    private int cCq;
    private String cCs;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.cCq = -1;
        this.cCl = str;
        this.cCs = str2;
        this.cCm = i;
    }

    public e qz(String str) {
        this.cCo = str;
        return this;
    }

    public int aup() {
        return this.cCq;
    }

    public void qA(String str) {
        this.cCp = str;
    }

    public String getBundleId() {
        return this.cCl;
    }

    public String auu() {
        return this.cCs;
    }

    public int aun() {
        return this.cCm;
    }

    public String auq() {
        return this.cCo;
    }

    public String aur() {
        return this.cCp;
    }
}
