package com.baidu.swan.apps.ap;
/* loaded from: classes10.dex */
public class ap {
    private int dyn;

    private ap() {
        this.dyn = 0;
    }

    public void lh(int i) {
        this.dyn = i;
    }

    public void reset() {
        this.dyn = 0;
    }

    public boolean aKI() {
        return this.dyn != 0;
    }

    public int aKJ() {
        return aKI() ? 1 : 0;
    }

    public static ap aKK() {
        return a.dyo;
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final ap dyo = new ap();
    }
}
