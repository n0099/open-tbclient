package com.baidu.swan.apps.y.a;
/* loaded from: classes10.dex */
public class c {
    protected int daU;
    protected String daV;
    protected long daW;
    protected boolean dah;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.dah = false;
        this.daU = i;
        this.daV = str;
    }

    public c(int i, String str, long j) {
        this.dah = false;
        this.daU = i;
        this.daV = str;
        this.daW = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.dah = false;
        this.daU = i;
        this.daV = str;
        this.daW = j;
        this.dah = z;
    }

    public int getId() {
        return this.daU;
    }

    public String aAa() {
        return this.daV;
    }

    public long aAb() {
        return this.daW;
    }

    public boolean aAc() {
        return this.dah;
    }
}
