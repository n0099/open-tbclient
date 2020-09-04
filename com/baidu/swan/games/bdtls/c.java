package com.baidu.swan.games.bdtls;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;
    private static volatile c dpm;
    private boolean mEnable = true;
    private a dpl = new a();

    public static c aLl() {
        if (dpm == null) {
            synchronized (c.class) {
                if (dpm == null) {
                    dpm = new c();
                }
            }
        }
        return dpm;
    }

    private c() {
    }

    public boolean uF(String str) {
        return this.dpl != null && this.dpl.uF(str);
    }

    public boolean isEnable() {
        if (this.dpl == null) {
            return false;
        }
        return this.dpl.aLk();
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void a(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        e.aLn().b(str, bVar);
    }
}
