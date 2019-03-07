package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class b extends c {
    private String bmO;
    private int bmP;
    private String bmQ;
    private String bmR;
    private String bmT;
    private String bmU;

    public b(String str, int i, String str2, int i2) {
        this.bmO = str;
        this.bmV = i2;
        this.bmU = str2;
        this.bmP = i;
    }

    public b jv(String str) {
        this.bmQ = str;
        return this;
    }

    public b jw(String str) {
        this.bmR = str;
        return this;
    }

    public void jx(String str) {
        this.bmT = str;
    }

    public String getBundleId() {
        return this.bmO;
    }

    public String Sl() {
        return this.bmU;
    }

    public int Sf() {
        return this.bmP;
    }

    public String Sh() {
        return this.bmQ;
    }

    public String Si() {
        return this.bmR;
    }

    public String Sj() {
        return this.bmT;
    }

    @Override // com.baidu.swan.pms.b.d.c
    public int Sk() {
        return this.bmV;
    }
}
