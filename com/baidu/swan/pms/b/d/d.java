package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class d extends c {
    private String bmV;
    private String bmW;
    private String bmY;

    public d(int i) {
        this.bna = i;
    }

    public d jz(String str) {
        this.bmW = str;
        return this;
    }

    public d jA(String str) {
        this.bmV = str;
        return this;
    }

    public d jB(String str) {
        this.bmY = str;
        return this;
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
