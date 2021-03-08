package com.baidu.swan.pms.c.d;
/* loaded from: classes3.dex */
public class f extends g {
    private String ewD;
    private String ewG;
    private String ewH;
    private int ewI;
    private String ewK;
    private int ewN;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.ewI = -1;
        this.ewD = str;
        this.ewK = str2;
        this.ewN = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.ewI = -1;
        this.ewD = str;
        this.ewK = str3;
        try {
            this.ewN = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.ewN = 0;
        }
    }

    public f yo(String str) {
        this.ewG = str;
        return this;
    }

    public int bdp() {
        return this.ewI;
    }

    public void yp(String str) {
        this.ewH = str;
    }

    public String getBundleId() {
        return this.ewD;
    }

    public String bdu() {
        return this.ewK;
    }

    public int bdw() {
        return this.ewN;
    }

    public String bdq() {
        return this.ewG;
    }

    public String bdr() {
        return this.ewH;
    }
}
