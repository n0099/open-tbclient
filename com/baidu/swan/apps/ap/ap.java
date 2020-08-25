package com.baidu.swan.apps.ap;
/* loaded from: classes8.dex */
public class ap {
    private int dbz;

    private ap() {
        this.dbz = 0;
    }

    public void ko(int i) {
        this.dbz = i;
    }

    public void reset() {
        this.dbz = 0;
    }

    public boolean aFv() {
        return this.dbz != 0;
    }

    public int aFw() {
        return aFv() ? 1 : 0;
    }

    public static ap aFx() {
        return a.dbA;
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static final ap dbA = new ap();
    }
}
