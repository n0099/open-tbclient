package com.baidu.swan.games.bdtls;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c dpi;
    private boolean mEnable = true;
    private a dph = new a();

    public static c aLl() {
        if (dpi == null) {
            synchronized (c.class) {
                if (dpi == null) {
                    dpi = new c();
                }
            }
        }
        return dpi;
    }

    private c() {
    }

    public boolean uE(String str) {
        return this.dph != null && this.dph.uE(str);
    }

    public boolean isEnable() {
        if (this.dph == null) {
            return false;
        }
        return this.dph.aLk();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aLn().b(str, bVar);
    }
}
