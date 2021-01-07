package com.baidu.swan.apps.ao;
/* loaded from: classes9.dex */
public class ap {
    private int dSf;

    private ap() {
        this.dSf = 0;
    }

    public void lQ(int i) {
        this.dSf = i;
    }

    public void reset() {
        this.dSf = 0;
    }

    public boolean aRZ() {
        return this.dSf != 0;
    }

    public int aSa() {
        return aRZ() ? 1 : 0;
    }

    public static ap aSb() {
        return a.dSg;
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final ap dSg = new ap();
    }
}
