package com.baidu.swan.apps.y.a;
/* loaded from: classes25.dex */
public class c {
    protected boolean dlv;
    protected int dmh;
    protected String dmi;
    protected long dmj;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.dlv = false;
        this.dmh = i;
        this.dmi = str;
    }

    public c(int i, String str, long j) {
        this.dlv = false;
        this.dmh = i;
        this.dmi = str;
        this.dmj = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.dlv = false;
        this.dmh = i;
        this.dmi = str;
        this.dmj = j;
        this.dlv = z;
    }

    public int getId() {
        return this.dmh;
    }

    public String aFb() {
        return this.dmi;
    }

    public long aFc() {
        return this.dmj;
    }

    public boolean aFd() {
        return this.dlv;
    }
}
