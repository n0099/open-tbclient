package com.baidu.swan.games.bdtls;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c cUE;
    private boolean mEnable = true;
    private a cUD = new a();

    public static c axL() {
        if (cUE == null) {
            synchronized (c.class) {
                if (cUE == null) {
                    cUE = new c();
                }
            }
        }
        return cUE;
    }

    private c() {
    }

    public boolean rg(String str) {
        return this.cUD != null && this.cUD.rg(str);
    }

    public boolean isEnable() {
        if (this.cUD == null) {
            return false;
        }
        return this.cUD.axK();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.axN().b(str, bVar);
    }
}
