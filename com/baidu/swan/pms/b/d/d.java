package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class d extends c {
    private String bmU;
    private String bmV;
    private String bmX;

    public d(int i) {
        this.bmZ = i;
    }

    public d jz(String str) {
        this.bmV = str;
        return this;
    }

    public d jA(String str) {
        this.bmU = str;
        return this;
    }

    public d jB(String str) {
        this.bmX = str;
        return this;
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
