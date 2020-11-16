package com.baidu.swan.apps.ap;
/* loaded from: classes7.dex */
public class ap {
    private int dCy;

    private ap() {
        this.dCy = 0;
    }

    public void ln(int i) {
        this.dCy = i;
    }

    public void reset() {
        this.dCy = 0;
    }

    public boolean aMA() {
        return this.dCy != 0;
    }

    public int aMB() {
        return aMA() ? 1 : 0;
    }

    public static ap aMC() {
        return a.dCz;
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final ap dCz = new ap();
    }
}
