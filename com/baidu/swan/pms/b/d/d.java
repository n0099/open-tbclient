package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class d extends c {
    private String bmQ;
    private String bmR;
    private String bmT;

    public d(int i) {
        this.bmV = i;
    }

    public d jy(String str) {
        this.bmR = str;
        return this;
    }

    public d jz(String str) {
        this.bmQ = str;
        return this;
    }

    public d jA(String str) {
        this.bmT = str;
        return this;
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
