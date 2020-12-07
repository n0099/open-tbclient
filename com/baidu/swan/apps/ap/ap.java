package com.baidu.swan.apps.ap;
/* loaded from: classes25.dex */
public class ap {
    private int dJw;

    private ap() {
        this.dJw = 0;
    }

    public void lL(int i) {
        this.dJw = i;
    }

    public void reset() {
        this.dJw = 0;
    }

    public boolean aPG() {
        return this.dJw != 0;
    }

    public int aPH() {
        return aPG() ? 1 : 0;
    }

    public static ap aPI() {
        return a.dJx;
    }

    /* loaded from: classes25.dex */
    private static class a {
        private static final ap dJx = new ap();
    }
}
