package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class d extends e {
    private String btJ;
    private int btK;
    private String btL;
    private String btN;
    private String btQ;

    public d(String str, int i, String str2, int i2) {
        super(i2);
        this.btJ = str;
        this.btQ = str2;
        this.btK = i;
    }

    public d kA(String str) {
        this.btL = str;
        return this;
    }

    public void kB(String str) {
        this.btN = str;
    }

    public String getBundleId() {
        return this.btJ;
    }

    public String WQ() {
        return this.btQ;
    }

    public int WK() {
        return this.btK;
    }

    public String WM() {
        return this.btL;
    }

    public String WN() {
        return this.btN;
    }
}
