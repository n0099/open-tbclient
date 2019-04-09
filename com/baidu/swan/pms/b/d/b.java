package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class b extends c {
    private String bmT;
    private int bmU;
    private String bmV;
    private String bmW;
    private String bmY;
    private String bmZ;

    public b(String str, int i, String str2, int i2) {
        this.bmT = str;
        this.bna = i2;
        this.bmZ = str2;
        this.bmU = i;
    }

    public b jw(String str) {
        this.bmV = str;
        return this;
    }

    public b jx(String str) {
        this.bmW = str;
        return this;
    }

    public void jy(String str) {
        this.bmY = str;
    }

    public String getBundleId() {
        return this.bmT;
    }

    public String Sj() {
        return this.bmZ;
    }

    public int Sd() {
        return this.bmU;
    }

    public String Sf() {
        return this.bmV;
    }

    public String Sg() {
        return this.bmW;
    }

    public String Sh() {
        return this.bmY;
    }

    @Override // com.baidu.swan.pms.b.d.c
    public int Si() {
        return this.bna;
    }
}
