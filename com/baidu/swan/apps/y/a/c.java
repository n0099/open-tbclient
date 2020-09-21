package com.baidu.swan.apps.y.a;
/* loaded from: classes3.dex */
public class c {
    protected boolean cFH;
    protected int cGt;
    protected String cGu;
    protected long cGv;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.cFH = false;
        this.cGt = i;
        this.cGu = str;
    }

    public c(int i, String str, long j) {
        this.cFH = false;
        this.cGt = i;
        this.cGu = str;
        this.cGv = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.cFH = false;
        this.cGt = i;
        this.cGu = str;
        this.cGv = j;
        this.cFH = z;
    }

    public int getId() {
        return this.cGt;
    }

    public String avv() {
        return this.cGu;
    }

    public long avw() {
        return this.cGv;
    }

    public boolean avx() {
        return this.cFH;
    }
}
