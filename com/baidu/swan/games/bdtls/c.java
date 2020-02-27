package com.baidu.swan.games.bdtls;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c ckH;
    private boolean mEnable = true;
    private a ckG = new a();

    public static c alF() {
        if (ckH == null) {
            synchronized (c.class) {
                if (ckH == null) {
                    ckH = new c();
                }
            }
        }
        return ckH;
    }

    private c() {
    }

    public boolean ou(String str) {
        return this.ckG != null && this.ckG.ou(str);
    }

    public boolean isEnable() {
        return this.ckG.alE() && this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.alH().b(str, bVar);
    }
}
