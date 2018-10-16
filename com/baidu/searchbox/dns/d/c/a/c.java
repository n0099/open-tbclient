package com.baidu.searchbox.dns.d.c.a;
/* loaded from: classes2.dex */
public class c extends Exception {
    protected int V;
    protected int W;

    public c() {
        this.V = -1;
        this.W = -1;
    }

    public c(String str) {
        super(str);
        this.V = -1;
        this.W = -1;
    }

    public c(int i, String str) {
        super(str);
        this.V = -1;
        this.W = -1;
        this.V = i;
    }

    public c(int i, int i2, String str) {
        super(str);
        this.V = -1;
        this.W = -1;
        this.V = i;
        this.W = i2;
    }

    public int G() {
        return this.V;
    }

    public int H() {
        return this.W;
    }
}
