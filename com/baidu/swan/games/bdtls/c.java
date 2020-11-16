package com.baidu.swan.games.bdtls;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c dPY;
    private boolean mEnable = true;
    private a dPX = new a();

    public static c aSr() {
        if (dPY == null) {
            synchronized (c.class) {
                if (dPY == null) {
                    dPY = new c();
                }
            }
        }
        return dPY;
    }

    private c() {
    }

    public boolean wm(String str) {
        return this.dPX != null && this.dPX.wm(str);
    }

    public boolean isEnable() {
        if (this.dPX == null) {
            return false;
        }
        return this.dPX.aSq();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aSt().b(str, bVar);
    }
}
