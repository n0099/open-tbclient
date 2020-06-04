package com.baidu.swan.apps.aq;
/* loaded from: classes11.dex */
public class an {
    private int cKq;

    private an() {
        this.cKq = 0;
    }

    public void hK(int i) {
        this.cKq = i;
    }

    public void reset() {
        this.cKq = 0;
    }

    public boolean atX() {
        return this.cKq != 0;
    }

    public static an atY() {
        return a.cKr;
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final an cKr = new an();
    }
}
