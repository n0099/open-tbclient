package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class e extends f {
    private String dmC;
    private int dmD;
    private String dmF;
    private String dmG;
    private int dmH;
    private String dmJ;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.dmH = -1;
        this.dmC = str;
        this.dmJ = str2;
        this.dmD = i;
    }

    public e tr(String str) {
        this.dmF = str;
        return this;
    }

    public int aGQ() {
        return this.dmH;
    }

    public void ts(String str) {
        this.dmG = str;
    }

    public String getBundleId() {
        return this.dmC;
    }

    public String aGV() {
        return this.dmJ;
    }

    public int aGO() {
        return this.dmD;
    }

    public String aGR() {
        return this.dmF;
    }

    public String aGS() {
        return this.dmG;
    }
}
