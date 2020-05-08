package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class c {
    protected int ceX;
    protected String ceY;
    protected long ceZ;
    protected boolean cen;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.cen = false;
        this.ceX = i;
        this.ceY = str;
    }

    public c(int i, String str, long j) {
        this.cen = false;
        this.ceX = i;
        this.ceY = str;
        this.ceZ = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.cen = false;
        this.ceX = i;
        this.ceY = str;
        this.ceZ = j;
        this.cen = z;
    }

    public int getId() {
        return this.ceX;
    }

    public String agZ() {
        return this.ceY;
    }

    public long aha() {
        return this.ceZ;
    }

    public boolean ahb() {
        return this.cen;
    }
}
