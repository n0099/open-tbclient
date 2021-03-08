package com.baidu.swan.apps.ao;
/* loaded from: classes8.dex */
public class ap {
    private int dRa;

    private ap() {
        this.dRa = 0;
    }

    public void ko(int i) {
        this.dRa = i;
    }

    public void reset() {
        this.dRa = 0;
    }

    public boolean aOB() {
        return this.dRa != 0;
    }

    public int aOC() {
        return aOB() ? 1 : 0;
    }

    public static ap aOD() {
        return a.dRb;
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static final ap dRb = new ap();
    }
}
