package com.baidu.swan.apps.ap;
/* loaded from: classes3.dex */
public class ap {
    private int ddF;

    private ap() {
        this.ddF = 0;
    }

    public void kz(int i) {
        this.ddF = i;
    }

    public void reset() {
        this.ddF = 0;
    }

    public boolean aGf() {
        return this.ddF != 0;
    }

    public int aGg() {
        return aGf() ? 1 : 0;
    }

    public static ap aGh() {
        return a.ddG;
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final ap ddG = new ap();
    }
}
