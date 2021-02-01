package com.baidu.live.liveroom.c;
/* loaded from: classes11.dex */
public class d {
    private static volatile d brt;
    private c bru;
    private b brv;

    private d() {
    }

    public static d My() {
        if (brt == null) {
            synchronized (d.class) {
                if (brt == null) {
                    brt = new d();
                }
            }
        }
        return brt;
    }

    private b Mz() {
        if (this.bru != null) {
            return this.bru.Mx();
        }
        return null;
    }

    public boolean Mw() {
        if (this.brv == null) {
            this.brv = Mz();
        }
        if (this.brv == null) {
            return false;
        }
        return this.brv.Mw();
    }

    public b MA() {
        if (this.brv != null) {
            return this.brv;
        }
        this.brv = Mz();
        return this.brv;
    }
}
