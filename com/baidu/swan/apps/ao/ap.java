package com.baidu.swan.apps.ao;
/* loaded from: classes8.dex */
public class ap {
    private int dNt;

    private ap() {
        this.dNt = 0;
    }

    public void kk(int i) {
        this.dNt = i;
    }

    public void reset() {
        this.dNt = 0;
    }

    public boolean aOf() {
        return this.dNt != 0;
    }

    public int aOg() {
        return aOf() ? 1 : 0;
    }

    public static ap aOh() {
        return a.dNu;
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static final ap dNu = new ap();
    }
}
