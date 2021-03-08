package com.baidu.swan.games.bdtls;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c eeP;
    private boolean mEnable = true;
    private a eeO = new a();

    public static c aUm() {
        if (eeP == null) {
            synchronized (c.class) {
                if (eeP == null) {
                    eeP = new c();
                }
            }
        }
        return eeP;
    }

    private c() {
    }

    public boolean wh(String str) {
        return this.eeO != null && this.eeO.wh(str);
    }

    public boolean isEnable() {
        if (this.eeO == null) {
            return false;
        }
        return this.eeO.aUl();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aUo().b(str, bVar);
    }
}
