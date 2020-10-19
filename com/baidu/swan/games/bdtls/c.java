package com.baidu.swan.games.bdtls;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c dDr;
    private boolean mEnable = true;
    private a dDq = new a();

    public static c aOF() {
        if (dDr == null) {
            synchronized (c.class) {
                if (dDr == null) {
                    dDr = new c();
                }
            }
        }
        return dDr;
    }

    private c() {
    }

    public boolean vK(String str) {
        return this.dDq != null && this.dDq.vK(str);
    }

    public boolean isEnable() {
        if (this.dDq == null) {
            return false;
        }
        return this.dDq.aOE();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aOH().b(str, bVar);
    }
}
