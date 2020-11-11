package com.baidu.swan.games.bdtls;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c dRG;
    private boolean mEnable = true;
    private a dRF = new a();

    public static c aSZ() {
        if (dRG == null) {
            synchronized (c.class) {
                if (dRG == null) {
                    dRG = new c();
                }
            }
        }
        return dRG;
    }

    private c() {
    }

    public boolean wr(String str) {
        return this.dRF != null && this.dRF.wr(str);
    }

    public boolean isEnable() {
        if (this.dRF == null) {
            return false;
        }
        return this.dRF.aSY();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aTb().b(str, bVar);
    }
}
