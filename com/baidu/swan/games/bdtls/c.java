package com.baidu.swan.games.bdtls;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c cJX;
    private boolean mEnable = true;
    private a cJW = new a();

    public static c atY() {
        if (cJX == null) {
            synchronized (c.class) {
                if (cJX == null) {
                    cJX = new c();
                }
            }
        }
        return cJX;
    }

    private c() {
    }

    public boolean pG(String str) {
        return this.cJW != null && this.cJW.pG(str);
    }

    public boolean isEnable() {
        return this.cJW.atX() && this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aua().b(str, bVar);
    }
}
