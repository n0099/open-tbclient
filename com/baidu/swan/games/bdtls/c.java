package com.baidu.swan.games.bdtls;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c cgq;
    private boolean mEnable = true;
    private a cgp = new a();

    public static c aiY() {
        if (cgq == null) {
            synchronized (c.class) {
                if (cgq == null) {
                    cgq = new c();
                }
            }
        }
        return cgq;
    }

    private c() {
    }

    public boolean oa(String str) {
        return this.cgp != null && this.cgp.oa(str);
    }

    public boolean isEnable() {
        return this.cgp.aiX() && this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aja().b(str, bVar);
    }
}
