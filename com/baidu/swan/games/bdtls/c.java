package com.baidu.swan.games.bdtls;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c ckJ;
    private boolean mEnable = true;
    private a ckI = new a();

    public static c alH() {
        if (ckJ == null) {
            synchronized (c.class) {
                if (ckJ == null) {
                    ckJ = new c();
                }
            }
        }
        return ckJ;
    }

    private c() {
    }

    public boolean ou(String str) {
        return this.ckI != null && this.ckI.ou(str);
    }

    public boolean isEnable() {
        return this.ckI.alG() && this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.alJ().b(str, bVar);
    }
}
