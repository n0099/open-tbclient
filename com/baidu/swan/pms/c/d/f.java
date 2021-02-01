package com.baidu.swan.pms.c.d;
/* loaded from: classes3.dex */
public class f extends g {
    private String evc;
    private String evf;
    private String evg;
    private int evh;
    private String evj;
    private int evm;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.evh = -1;
        this.evc = str;
        this.evj = str2;
        this.evm = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.evh = -1;
        this.evc = str;
        this.evj = str3;
        try {
            this.evm = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.evm = 0;
        }
    }

    public f yh(String str) {
        this.evf = str;
        return this;
    }

    public int bdn() {
        return this.evh;
    }

    public void yi(String str) {
        this.evg = str;
    }

    public String getBundleId() {
        return this.evc;
    }

    public String bds() {
        return this.evj;
    }

    public int bdu() {
        return this.evm;
    }

    public String bdo() {
        return this.evf;
    }

    public String bdp() {
        return this.evg;
    }
}
