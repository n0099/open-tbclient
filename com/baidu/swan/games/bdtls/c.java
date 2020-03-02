package com.baidu.swan.games.bdtls;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c ckI;
    private boolean mEnable = true;
    private a ckH = new a();

    public static c alH() {
        if (ckI == null) {
            synchronized (c.class) {
                if (ckI == null) {
                    ckI = new c();
                }
            }
        }
        return ckI;
    }

    private c() {
    }

    public boolean ou(String str) {
        return this.ckH != null && this.ckH.ou(str);
    }

    public boolean isEnable() {
        return this.ckH.alG() && this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.alJ().b(str, bVar);
    }
}
