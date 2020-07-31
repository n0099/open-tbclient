package com.baidu.swan.apps.aq;
/* loaded from: classes7.dex */
public class aq {
    private int cSA;

    private aq() {
        this.cSA = 0;
    }

    public void ig(int i) {
        this.cSA = i;
    }

    public void reset() {
        this.cSA = 0;
    }

    public boolean axm() {
        return this.cSA != 0;
    }

    public int axn() {
        return axm() ? 1 : 0;
    }

    public static aq axo() {
        return a.cSB;
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final aq cSB = new aq();
    }
}
