package com.baidu.swan.games.bdtls;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c efT;
    private boolean mEnable = true;
    private a efS = new a();

    public static c aXQ() {
        if (efT == null) {
            synchronized (c.class) {
                if (efT == null) {
                    efT = new c();
                }
            }
        }
        return efT;
    }

    private c() {
    }

    public boolean wS(String str) {
        return this.efS != null && this.efS.wS(str);
    }

    public boolean isEnable() {
        if (this.efS == null) {
            return false;
        }
        return this.efS.aXP();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aXS().b(str, bVar);
    }
}
