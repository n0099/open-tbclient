package com.baidu.live.liveroom.c;
/* loaded from: classes11.dex */
public class d {
    private static volatile d bsE;
    private c bsF;
    private b bsG;

    private d() {
    }

    public static d OV() {
        if (bsE == null) {
            synchronized (d.class) {
                if (bsE == null) {
                    bsE = new d();
                }
            }
        }
        return bsE;
    }

    private b OW() {
        if (this.bsF != null) {
            return this.bsF.OU();
        }
        return null;
    }

    public boolean OT() {
        if (this.bsG == null) {
            this.bsG = OW();
        }
        if (this.bsG == null) {
            return false;
        }
        return this.bsG.OT();
    }

    public b OX() {
        if (this.bsG != null) {
            return this.bsG;
        }
        this.bsG = OW();
        return this.bsG;
    }
}
