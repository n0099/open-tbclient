package com.baidu.searchbox.dns.d.c.a;
/* loaded from: classes6.dex */
public class c extends Exception {
    protected int am;
    protected int an;

    public c() {
        this.am = -1;
        this.an = -1;
    }

    public c(String str) {
        super(str);
        this.am = -1;
        this.an = -1;
    }

    public c(int i, String str) {
        super(str);
        this.am = -1;
        this.an = -1;
        this.am = i;
    }

    public c(int i, int i2, String str) {
        super(str);
        this.am = -1;
        this.an = -1;
        this.am = i;
        this.an = i2;
    }

    public int R() {
        return this.am;
    }

    public int S() {
        return this.an;
    }
}
