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

    public boolean aRY() {
        return this.dSf != 0;
    }

    public int aRZ() {
        return aRY() ? 1 : 0;
    }

    public static ap aSa() {
        return a.dSg;
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final ap dSg = new ap();
    }
}
