package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class b extends c {
    private String bmP;
    private int bmQ;
    private String bmR;
    private String bmS;
    private String bmU;
    private String bmV;

    public b(String str, int i, String str2, int i2) {
        this.bmP = str;
        this.bmW = i2;
        this.bmV = str2;
        this.bmQ = i;
    }

    public b jv(String str) {
        this.bmR = str;
        return this;
    }

    public b jw(String str) {
        this.bmS = str;
        return this;
    }

    public void jx(String str) {
        this.bmU = str;
    }

    public String getBundleId() {
        return this.bmP;
    }

    public String Sl() {
        return this.bmV;
    }

    public int Sf() {
        return this.bmQ;
    }

    public String Sh() {
        return this.bmR;
    }

    public String Si() {
        return this.bmS;
    }

    public String Sj() {
        return this.bmU;
    }

    @Override // com.baidu.swan.pms.b.d.c
    public int Sk() {
        return this.bmW;
    }
}
