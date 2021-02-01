package com.baidu.swan.apps.y.a;
/* loaded from: classes9.dex */
public class c {
    protected boolean dnP;
    protected int doD;
    protected String doE;
    protected long doF;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.dnP = false;
        this.doD = i;
        this.doE = str;
    }

    public c(int i, String str, long j) {
        this.dnP = false;
        this.doD = i;
        this.doE = str;
        this.doF = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.dnP = false;
        this.doD = i;
        this.doE = str;
        this.doF = j;
        this.dnP = z;
    }

    public int getId() {
        return this.doD;
    }

    public String aCY() {
        return this.doE;
    }

    public long aCZ() {
        return this.doF;
    }

    public boolean aDa() {
        return this.dnP;
    }
}
