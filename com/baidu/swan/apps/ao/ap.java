package com.baidu.swan.apps.ao;
/* loaded from: classes9.dex */
public class ap {
    private int dPz;

    private ap() {
        this.dPz = 0;
    }

    public void kn(int i) {
        this.dPz = i;
    }

    public void reset() {
        this.dPz = 0;
    }

    public boolean aOy() {
        return this.dPz != 0;
    }

    public int aOz() {
        return aOy() ? 1 : 0;
    }

    public static ap aOA() {
        return a.dPA;
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final ap dPA = new ap();
    }
}
