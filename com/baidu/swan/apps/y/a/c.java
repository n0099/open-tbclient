package com.baidu.swan.apps.y.a;
/* loaded from: classes10.dex */
public class c {
    protected boolean cRL;
    protected int cSw;
    protected String cSx;
    protected long cSy;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.cRL = false;
        this.cSw = i;
        this.cSx = str;
    }

    public c(int i, String str, long j) {
        this.cRL = false;
        this.cSw = i;
        this.cSx = str;
        this.cSy = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.cRL = false;
        this.cSw = i;
        this.cSx = str;
        this.cSy = j;
        this.cRL = z;
    }

    public int getId() {
        return this.cSw;
    }

    public String ayg() {
        return this.cSx;
    }

    public long ayh() {
        return this.cSy;
    }

    public boolean ayi() {
        return this.cRL;
    }
}
