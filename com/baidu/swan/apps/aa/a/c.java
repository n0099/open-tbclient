package com.baidu.swan.apps.aa.a;
/* loaded from: classes11.dex */
public class c {
    protected boolean ctI;
    protected int cuu;
    protected String cuv;
    protected long cuw;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.ctI = false;
        this.cuu = i;
        this.cuv = str;
    }

    public c(int i, String str, long j) {
        this.ctI = false;
        this.cuu = i;
        this.cuv = str;
        this.cuw = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.ctI = false;
        this.cuu = i;
        this.cuv = str;
        this.cuw = j;
        this.ctI = z;
    }

    public int getId() {
        return this.cuu;
    }

    public String aly() {
        return this.cuv;
    }

    public long alz() {
        return this.cuw;
    }

    public boolean alA() {
        return this.ctI;
    }
}
