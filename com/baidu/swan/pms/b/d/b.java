package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class b extends c {
    private String bmS;
    private int bmT;
    private String bmU;
    private String bmV;
    private String bmX;
    private String bmY;

    public b(String str, int i, String str2, int i2) {
        this.bmS = str;
        this.bmZ = i2;
        this.bmY = str2;
        this.bmT = i;
    }

    public b jw(String str) {
        this.bmU = str;
        return this;
    }

    public b jx(String str) {
        this.bmV = str;
        return this;
    }

    public void jy(String str) {
        this.bmX = str;
    }

    public String getBundleId() {
        return this.bmS;
    }

    public String Sj() {
        return this.bmY;
    }

    public int Sd() {
        return this.bmT;
    }

    public String Sf() {
        return this.bmU;
    }

    public String Sg() {
        return this.bmV;
    }

    public String Sh() {
        return this.bmX;
    }

    @Override // com.baidu.swan.pms.b.d.c
    public int Si() {
        return this.bmZ;
    }
}
