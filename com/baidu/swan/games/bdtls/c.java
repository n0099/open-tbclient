package com.baidu.swan.games.bdtls;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c deZ;
    private boolean mEnable = true;
    private a deY = new a();

    public static c aCw() {
        if (deZ == null) {
            synchronized (c.class) {
                if (deZ == null) {
                    deZ = new c();
                }
            }
        }
        return deZ;
    }

    private c() {
    }

    public boolean sm(String str) {
        return this.deY != null && this.deY.sm(str);
    }

    public boolean isEnable() {
        if (this.deY == null) {
            return false;
        }
        return this.deY.aCv();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aCy().b(str, bVar);
    }
}
