package com.baidu.swan.games.bdtls;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c drn;
    private boolean mEnable = true;
    private a drm = new a();

    public static c aLW() {
        if (drn == null) {
            synchronized (c.class) {
                if (drn == null) {
                    drn = new c();
                }
            }
        }
        return drn;
    }

    private c() {
    }

    public boolean uY(String str) {
        return this.drm != null && this.drm.uY(str);
    }

    public boolean isEnable() {
        if (this.drm == null) {
            return false;
        }
        return this.drm.aLV();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aLY().b(str, bVar);
    }
}
