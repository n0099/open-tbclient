package com.baidu.swan.games.bdtls;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c ebh;
    private boolean mEnable = true;
    private a ebg = new a();

    public static c aTX() {
        if (ebh == null) {
            synchronized (c.class) {
                if (ebh == null) {
                    ebh = new c();
                }
            }
        }
        return ebh;
    }

    private c() {
    }

    public boolean vH(String str) {
        return this.ebg != null && this.ebg.vH(str);
    }

    public boolean isEnable() {
        if (this.ebg == null) {
            return false;
        }
        return this.ebg.aTW();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aTZ().b(str, bVar);
    }
}
