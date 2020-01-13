package com.baidu.swan.games.bdtls;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c cgD;
    private boolean mEnable = true;
    private a cgC = new a();

    public static c ajr() {
        if (cgD == null) {
            synchronized (c.class) {
                if (cgD == null) {
                    cgD = new c();
                }
            }
        }
        return cgD;
    }

    private c() {
    }

    public boolean od(String str) {
        return this.cgC != null && this.cgC.od(str);
    }

    public boolean isEnable() {
        return this.cgC.ajq() && this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.ajt().b(str, bVar);
    }
}
