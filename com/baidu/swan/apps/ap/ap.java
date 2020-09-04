package com.baidu.swan.apps.ap;
/* loaded from: classes8.dex */
public class ap {
    private int dbD;

    private ap() {
        this.dbD = 0;
    }

    public void ko(int i) {
        this.dbD = i;
    }

    public void reset() {
        this.dbD = 0;
    }

    public boolean aFv() {
        return this.dbD != 0;
    }

    public int aFw() {
        return aFv() ? 1 : 0;
    }

    public static ap aFx() {
        return a.dbE;
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static final ap dbE = new ap();
    }
}
