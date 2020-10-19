package com.baidu.swan.apps.ap;
/* loaded from: classes10.dex */
public class ap {
    private int dpN;

    private ap() {
        this.dpN = 0;
    }

    public void kW(int i) {
        this.dpN = i;
    }

    public void reset() {
        this.dpN = 0;
    }

    public boolean aIO() {
        return this.dpN != 0;
    }

    public int aIP() {
        return aIO() ? 1 : 0;
    }

    public static ap aIQ() {
        return a.dpO;
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final ap dpO = new ap();
    }
}
