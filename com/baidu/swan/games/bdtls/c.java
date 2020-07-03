package com.baidu.swan.games.bdtls;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c cZo;
    private boolean mEnable = true;
    private a cZn = new a();

    public static c ayR() {
        if (cZo == null) {
            synchronized (c.class) {
                if (cZo == null) {
                    cZo = new c();
                }
            }
        }
        return cZo;
    }

    private c() {
    }

    public boolean ro(String str) {
        return this.cZn != null && this.cZn.ro(str);
    }

    public boolean isEnable() {
        if (this.cZn == null) {
            return false;
        }
        return this.cZn.ayQ();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.ayT().b(str, bVar);
    }
}
