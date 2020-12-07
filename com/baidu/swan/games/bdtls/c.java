package com.baidu.swan.games.bdtls;
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c dWW;
    private boolean mEnable = true;
    private a dWV = new a();

    public static c aVw() {
        if (dWW == null) {
            synchronized (c.class) {
                if (dWW == null) {
                    dWW = new c();
                }
            }
        }
        return dWW;
    }

    private c() {
    }

    public boolean wT(String str) {
        return this.dWV != null && this.dWV.wT(str);
    }

    public boolean isEnable() {
        if (this.dWV == null) {
            return false;
        }
        return this.dWV.aVv();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aVy().b(str, bVar);
    }
}
