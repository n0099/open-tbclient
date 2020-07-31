package com.baidu.swan.pms.c.d;
/* loaded from: classes19.dex */
public class f extends g {
    private String dxf;
    private int dxg;
    private String dxi;
    private String dxj;
    private int dxk;
    private String dxm;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.dxk = -1;
        this.dxf = str;
        this.dxm = str2;
        this.dxg = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.dxk = -1;
        this.dxf = str;
        this.dxm = str3;
        try {
            this.dxg = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.dxg = 0;
        }
    }

    public f uC(String str) {
        this.dxi = str;
        return this;
    }

    public int aLN() {
        return this.dxk;
    }

    public void uD(String str) {
        this.dxj = str;
    }

    public String getBundleId() {
        return this.dxf;
    }

    public String aLS() {
        return this.dxm;
    }

    public int aLL() {
        return this.dxg;
    }

    public String aLO() {
        return this.dxi;
    }

    public String aLP() {
        return this.dxj;
    }
}
