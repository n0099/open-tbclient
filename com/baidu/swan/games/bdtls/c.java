package com.baidu.swan.games.bdtls;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c cJR;
    private boolean mEnable = true;
    private a cJQ = new a();

    public static c atY() {
        if (cJR == null) {
            synchronized (c.class) {
                if (cJR == null) {
                    cJR = new c();
                }
            }
        }
        return cJR;
    }

    private c() {
    }

    public boolean pG(String str) {
        return this.cJQ != null && this.cJQ.pG(str);
    }

    public boolean isEnable() {
        return this.cJQ.atX() && this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aua().b(str, bVar);
    }
}
