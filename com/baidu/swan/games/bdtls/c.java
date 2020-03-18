package com.baidu.swan.games.bdtls;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c ckU;
    private boolean mEnable = true;
    private a ckT = new a();

    public static c alK() {
        if (ckU == null) {
            synchronized (c.class) {
                if (ckU == null) {
                    ckU = new c();
                }
            }
        }
        return ckU;
    }

    private c() {
    }

    public boolean ot(String str) {
        return this.ckT != null && this.ckT.ot(str);
    }

    public boolean isEnable() {
        return this.ckT.alJ() && this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.alM().b(str, bVar);
    }
}
