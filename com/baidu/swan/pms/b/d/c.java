package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class c extends e {
    private String btO;
    private String btP;

    public c(String str, String str2, int i) {
        super(i);
        this.btO = str;
        this.btP = str2;
    }

    public c kz(String str) {
        this.btP = str;
        return this;
    }

    public String WO() {
        return this.btO;
    }

    public String WP() {
        return this.btP;
    }
}
