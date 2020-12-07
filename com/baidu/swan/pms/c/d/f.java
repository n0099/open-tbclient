package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public class f extends g {
    private String eob;
    private String eoe;
    private String eog;
    private int eoh;
    private String eoj;
    private int eol;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.eoh = -1;
        this.eob = str;
        this.eoj = str2;
        this.eol = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.eoh = -1;
        this.eob = str;
        this.eoj = str3;
        try {
            this.eol = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.eol = 0;
        }
    }

    public f za(String str) {
        this.eoe = str;
        return this;
    }

    public int bey() {
        return this.eoh;
    }

    public void zb(String str) {
        this.eog = str;
    }

    public String getBundleId() {
        return this.eob;
    }

    public String beD() {
        return this.eoj;
    }

    public int beF() {
        return this.eol;
    }

    public String bez() {
        return this.eoe;
    }

    public String beA() {
        return this.eog;
    }
}
