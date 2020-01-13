package com.baidu.live.liveroom.b;
/* loaded from: classes2.dex */
public class d {
    private static volatile d arS;
    private c arT;
    private b arU;

    private d() {
    }

    public static d wq() {
        if (arS == null) {
            synchronized (d.class) {
                if (arS == null) {
                    arS = new d();
                }
            }
        }
        return arS;
    }

    private b wr() {
        if (this.arT != null) {
            return this.arT.wp();
        }
        return null;
    }

    public boolean wo() {
        if (this.arU == null) {
            this.arU = wr();
        }
        if (this.arU == null) {
            return false;
        }
        return this.arU.wo();
    }

    public b ws() {
        if (this.arU != null) {
            return this.arU;
        }
        this.arU = wr();
        return this.arU;
    }
}
