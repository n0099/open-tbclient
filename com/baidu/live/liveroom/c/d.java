package com.baidu.live.liveroom.c;
/* loaded from: classes4.dex */
public class d {
    private static volatile d bno;
    private c bnp;
    private b bnq;

    private d() {
    }

    public static d Ny() {
        if (bno == null) {
            synchronized (d.class) {
                if (bno == null) {
                    bno = new d();
                }
            }
        }
        return bno;
    }

    private b Nz() {
        if (this.bnp != null) {
            return this.bnp.Nx();
        }
        return null;
    }

    public boolean Nw() {
        if (this.bnq == null) {
            this.bnq = Nz();
        }
        if (this.bnq == null) {
            return false;
        }
        return this.bnq.Nw();
    }

    public b NA() {
        if (this.bnq != null) {
            return this.bnq;
        }
        this.bnq = Nz();
        return this.bnq;
    }
}
