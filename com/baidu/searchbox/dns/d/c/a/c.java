package com.baidu.searchbox.dns.d.c.a;
/* loaded from: classes2.dex */
public class c extends Exception {
    public int am;
    public int an;

    public c() {
        this.am = -1;
        this.an = -1;
    }

    public int P() {
        return this.am;
    }

    public int Q() {
        return this.an;
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
}
