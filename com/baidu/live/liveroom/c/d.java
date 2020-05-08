package com.baidu.live.liveroom.c;
/* loaded from: classes3.dex */
public class d {
    private static volatile d aPJ;
    private c aPK;
    private b aPL;

    private d() {
    }

    public static d Dp() {
        if (aPJ == null) {
            synchronized (d.class) {
                if (aPJ == null) {
                    aPJ = new d();
                }
            }
        }
        return aPJ;
    }

    private b Dq() {
        if (this.aPK != null) {
            return this.aPK.Do();
        }
        return null;
    }

    public boolean Dn() {
        if (this.aPL == null) {
            this.aPL = Dq();
        }
        if (this.aPL == null) {
            return false;
        }
        return this.aPL.Dn();
    }

    public b Dr() {
        if (this.aPL != null) {
            return this.aPL;
        }
        this.aPL = Dq();
        return this.aPL;
    }
}
