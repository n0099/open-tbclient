package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class d extends c {
    private String bmR;
    private String bmS;
    private String bmU;

    public d(int i) {
        this.bmW = i;
    }

    public d jy(String str) {
        this.bmS = str;
        return this;
    }

    public d jz(String str) {
        this.bmR = str;
        return this;
    }

    public d jA(String str) {
        this.bmU = str;
        return this;
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
