package com.baidu.swan.games.bdtls;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c dLO;
    private boolean mEnable = true;
    private a dLN = new a();

    public static c aQz() {
        if (dLO == null) {
            synchronized (c.class) {
                if (dLO == null) {
                    dLO = new c();
                }
            }
        }
        return dLO;
    }

    private c() {
    }

    public boolean wd(String str) {
        return this.dLN != null && this.dLN.wd(str);
    }

    public boolean isEnable() {
        if (this.dLN == null) {
            return false;
        }
        return this.dLN.aQy();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aQB().b(str, bVar);
    }
}
