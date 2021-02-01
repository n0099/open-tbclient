package com.baidu.swan.games.bdtls;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c edo;
    private boolean mEnable = true;
    private a edn = new a();

    public static c aUj() {
        if (edo == null) {
            synchronized (c.class) {
                if (edo == null) {
                    edo = new c();
                }
            }
        }
        return edo;
    }

    private c() {
    }

    public boolean wa(String str) {
        return this.edn != null && this.edn.wa(str);
    }

    public boolean isEnable() {
        if (this.edn == null) {
            return false;
        }
        return this.edn.aUi();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aUl().b(str, bVar);
    }
}
