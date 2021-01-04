package com.baidu.swan.apps.y.a;
/* loaded from: classes9.dex */
public class c {
    protected boolean dqu;
    protected int drg;
    protected String drh;
    protected long dri;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.dqu = false;
        this.drg = i;
        this.drh = str;
    }

    public c(int i, String str, long j) {
        this.dqu = false;
        this.drg = i;
        this.drh = str;
        this.dri = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.dqu = false;
        this.drg = i;
        this.drh = str;
        this.dri = j;
        this.dqu = z;
    }

    public int getId() {
        return this.drg;
    }

    public String aGv() {
        return this.drh;
    }

    public long aGw() {
        return this.dri;
    }

    public boolean aGx() {
        return this.dqu;
    }
}
